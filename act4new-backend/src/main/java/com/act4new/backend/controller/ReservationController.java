package com.act4new.backend.controller;


import com.act4new.backend.dto.ReservationDTO;
import com.act4new.backend.model.Reservation;
import com.act4new.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/dores")
    public String reserve(@RequestBody ReservationDTO reservation){
        reservationService.louerArticle(reservation);
        return "Article reservé";
    }
}
