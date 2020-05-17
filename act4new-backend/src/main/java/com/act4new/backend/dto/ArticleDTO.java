package com.act4new.backend.dto;

import java.util.ArrayList;
import java.util.List;

import com.act4new.backend.model.Image;

public class ArticleDTO {

	private Long id;
	private String nom;
	private String description;
	private Long id_proprietaire;
	private List<Image> image = new ArrayList<>();
	private boolean dispo = false;
	private String location;
	private float prix;
	private String marque;
	private String etat;
	
	public ArticleDTO(String description, String location, float prix) {
		super();
		this.description = description;
		this.location = location;
		this.prix = prix;
	}
	public ArticleDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Image> getImages() {
		return image;
	}
	public void setImages(List<Image> image) {
		this.image = image;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getId_proprietaire() {
		return id_proprietaire;
	}
	public void setId_proprietaire(Long id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}
	
	
}
