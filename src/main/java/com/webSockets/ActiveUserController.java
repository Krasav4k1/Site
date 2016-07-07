package com.webSockets;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.security.Principal;

@Controller
public class ActiveUserController {

  private ActiveUserService activeUserService;

  @Inject
  public ActiveUserController(ActiveUserService activeUserService) {
    this.activeUserService = activeUserService;
  }
  
  @MessageMapping("/activeUsers")
  public void activeUsers(Message<Object> message) {
    Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
    activeUserService.mark(principal.getName());
  }

}
