package com.act4new.backend.model;

import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Users id_client;

    @OneToOne
    @JoinColumn(name = "id_bike")
    private Article id_bike;

    String datdebut;
    String datefin;

    public Reservation() {
        super();
    }

    public Reservation(Users id_client, Article id_bike, String datdebut, String datefin) {
        this.id_client = id_client;
        this.id_bike = id_bike;
        this.datdebut = datdebut;
        this.datefin = datefin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getId_client() {
        return id_client;
    }

    public void setId_client(Users id_client) {
        this.id_client = id_client;
    }

    public Article getId_bike() {
        return id_bike;
    }

    public void setId_bike(Article id_bike) {
        this.id_bike = id_bike;
    }

    public String getDatdebut() {
        return datdebut;
    }

    public void setDatdebut(String datdebut) {
        this.datdebut = datdebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
}
