package com.act4new.backend.service;


import com.act4new.backend.dao.ArticleDAO;
import com.act4new.backend.dao.ReservationDAO;
import com.act4new.backend.dao.UserDAO;
import com.act4new.backend.dto.ReservationDTO;
import com.act4new.backend.model.Article;
import com.act4new.backend.model.Reservation;
import com.act4new.backend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationService {

    @Autowired
    ReservationDAO reservationDAO;

    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    UserDAO userDAO;

    @Transactional
    public void louerArticle(ReservationDTO res){
        Users user =userDAO.getOne(res.getId_client());
        Article article = articleDAO.getOne(res.getId_article());
        Reservation r = new Reservation(user,article,res.getDebut(),res.getFin());
        reservationDAO.save(r);

    }
}
