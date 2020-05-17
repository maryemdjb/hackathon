package com.act4new.backend.dto;

public class ReservationDTO {


    private Long id_client;
    private Long id_article;
    private String debut;
    private String fin;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id_client, Long id_article, String debut, String fin) {
        this.id_client = id_client;
        this.id_article = id_article;
        this.debut = debut;
        this.fin = fin;
    }


    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
