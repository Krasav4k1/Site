package com.repository;

import com.entity.Frends;
import com.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FrendsRepository extends CrudRepository<Frends,Integer>{

    @Query(value = "select a from Frends a where" +
            "(a.userSend like concat(:idUser)) " +
            "or (a.userRecived like concat(:idUser))"+
            "and (a.sendFrendship like concat(:sendFrendship))" +
            "and (a.recivedFrendsip like concat(:recivedFrendsip))" +
            "and (a.spesialStatys like concat(:specialStatys))")
    Iterable<Frends> findFrendsByUserId (@Param("idUser") int idUser,
                                       @Param("sendFrendship") int sendFrendship,
                                       @Param("recivedFrendsip") int recivedFrendsip,
                                       @Param("specialStatys") int specialStatys);

    @Query(value = "select a from Frends a where" +
            "(a.userRecived like concat(:idUser)) " +
            "or (a.userRecived like concat(:idUser))"+
            "and (a.sendFrendship like concat(:sendFrendship))" +
            "and (a.recivedFrendsip like concat(:recivedFrendsip))" +
            "and (a.spesialStatys like concat(:specialStatys))")
    Iterable<Frends> findFrendsByUserIdRecived (@Param("idUser") int idUser,
                                         @Param("sendFrendship") int sendFrendship,
                                         @Param("recivedFrendsip") int recivedFrendsip,
                                         @Param("specialStatys") int specialStatys);

    @Query(value = "SELECT a from Frends a where (a.userRecived like concat(:idR)) and (a.userSend like concat(:idS))")
    Frends findRecivedAndSend(@Param("idR") int idR, @Param("idS") int idS);

}
