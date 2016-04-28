package com.servise.impl;

import com.entity.Frends;
import com.entity.User;
import com.repository.FrendsRepository;
import com.servise.FrendsService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrendsServiceImpl implements FrendsService{

    @Autowired
    FrendsRepository frendsRepository;
    @Autowired
    UserService userService;

    public void daleteByObjectLine(Frends frends){
        frendsRepository.delete(frends);
    }

    public void daleteByIdLine(int id){
        frendsRepository.delete(id);
    }

    public Frends findRecivedAndSend(int idR, int idS){
        return frendsRepository.findRecivedAndSend(idR,idS);
    }

    public void save(Frends frends){
        frendsRepository.save(frends);
    }

    public List<User> getFrends(Principal principal, int sendFrendship, int recivedFrenship, int spesialStatys) {
        List<User> frendses = new ArrayList<User>();
        int count = 0;
        for (Frends fr : frendsRepository.findFrendsByUserId(Integer.parseInt(principal.getName()), sendFrendship, recivedFrenship, spesialStatys)) {
            if (fr.getUserSend().getId() == Integer.parseInt(principal.getName())) {
                frendses.add(count, fr.getUserRecived());
                count++;
            }
        }
        for (Frends fr : frendsRepository.findFrendsByUserIdRecived(Integer.parseInt(principal.getName()), sendFrendship, recivedFrenship, spesialStatys)) {
            if (fr.getUserRecived().getId() == Integer.parseInt(principal.getName())) {
                frendses.add(count, fr.getUserSend());
                count++;
            }
        }
        return frendses;
    }

    public void daleteFrends(Principal principal, int id) {
        User user = userService.findById(Integer.parseInt(principal.getName()));
        Frends friends = findRecivedAndSend(id,user.getId());
        Frends friends2 = findRecivedAndSend(user.getId(),id);
        if (friends != null){
            friends.setUserSend(null);
            friends.setUserRecived(null);
            frendsRepository.delete(friends.getId());
        }else if(friends2 != null){
            friends2.setUserSend(null);
            friends2.setUserRecived(null);
            frendsRepository.delete(friends2.getId());
        }
    }

    public void addFrend(Principal principal, int id) {
        User user = userService.findById(Integer.parseInt(principal.getName()));
        Frends frend = new Frends();
        frend.setUserSend(user);
        frend.setUserRecived(userService.findById(id));
        frend.setRecivedFrendsip(1);
        frend.setSendFrendship(1);
        frend.setSpesialStatys(1);
        save(frend);
    }

}
