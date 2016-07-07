package com.servise;

import com.entity.Frends;
import com.entity.User;

import java.security.Principal;
import java.util.List;

public interface FrendsService {

    void daleteByObjectLine(Frends frends);

    void daleteByIdLine(int id);

    Frends findRecivedAndSend(int idR, int idS);

    void save(Frends frends);

    List<User> getFrends(Principal principal, int sendFrendship, int recivedFrenship, int spesialStatys);

    void daleteFrends(Principal principal, int id);

    void addFrend(Principal principal, int id);
}
