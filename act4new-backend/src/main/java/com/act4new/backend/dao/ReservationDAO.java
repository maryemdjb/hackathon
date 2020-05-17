package com.act4new.backend.dao;

import com.act4new.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import com.act4new.backend.model.Reservation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReservationDAO extends JpaRepository<Reservation,Long>{


}
