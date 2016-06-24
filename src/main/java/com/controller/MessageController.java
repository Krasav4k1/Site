package com.controller;

import com.entity.Messages;
import com.entity.User;
import com.servise.FrendsService;
import com.servise.MessageService;
import com.servise.UserService;
import com.webSockets.ChatMessage;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller

public class MessageController {

    @Autowired
    FrendsService frendsService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

    private SimpMessagingTemplate template;

    @Inject
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }


    @MessageMapping("/chat")
    public void greeting(Message<Object> message, @Payload ChatMessage chatMessage, Principal principal) throws Exception {
        User user = userService.findById(Integer.parseInt(principal.getName()));
        chatMessage.setFirstNameAndLastName(user.getFirstName() + " " + user.getLastName());
        chatMessage.setFotoSender(user.getFoto());
        String idSender = principal.getName();
        chatMessage.setSender(idSender);
        String recipient = chatMessage.getRecipient();
        if (!idSender.equals(recipient)) {
            template.convertAndSendToUser(idSender, "/queue/messages", chatMessage);
        }

        template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
    }

    @RequestMapping("/message")
    public String ShowMessage(Principal principal, Model model){
        model.addAttribute("userSendMesage", userService.findById(Integer.parseInt(principal.getName())));
        return "Message";
    }

    @RequestMapping("getAllUserForMessegerPage.json")
    public @ResponseBody
    Iterable<User> getAllUserForMessegerPage(Principal principal){
        return frendsService.getFrends(principal,1,1,1);
    }

    @ModelAttribute("newMessege")
    public Messages newMessege(){
        return new Messages();
    }


    @RequestMapping("getDialog-Resived-{idUser}-{beginCount}")
    public @ResponseBody
    List<Messages> getMessegForUserId(Principal principal, @PathVariable("idUser") int idUserResived, @PathVariable("beginCount") int beginCount){
        List<Messages> list = new ArrayList<Messages>();
        int countMeseg = 10;
        Hibernate.initialize(messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived));
        if(beginCount + countMeseg <= messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived).size()){
            for(int d = beginCount; d < beginCount + countMeseg; d++){
                list.add(messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived).get(d));
            }
        }else{
            int rizn = beginCount + countMeseg - messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived).size();
            for(int d = beginCount; d < beginCount + countMeseg - rizn; d++){
                list.add(messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()),idUserResived).get(d));
            }
        }
        return list;
    }


    @RequestMapping(value = "/sendMessege", method = RequestMethod.POST)
    public @ResponseBody
    Iterable<Messages> PostJson(@RequestBody List<String> request, Principal principal){
        Messages messages = new Messages();
        messages.setUserSentMessager(userService.findById(Integer.parseInt(principal.getName())));
        messages.setUserReceivedMessages(userService.findById(Integer.parseInt(request.get(1))));
        messages.setMessager(request.get(0));
        messages.setStatys(1);
        messageService.save(messages);
        return messageService.findMessegeByIdUserResiver(Integer.parseInt(principal.getName()), Integer.parseInt(request.get(1)));
    }

}
