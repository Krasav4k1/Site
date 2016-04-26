package com.servise;

import com.entity.Frends;
import com.entity.User;
import com.repository.FrendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrendsService {

    @Autowired
    FrendsRepository frendsRepository;

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
                frendses.add(count, fr.getUserSend());
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

}
