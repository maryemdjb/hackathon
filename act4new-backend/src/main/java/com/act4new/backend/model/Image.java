package com.act4new.backend.model;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] capture;
	
	

	public Image(byte[] capture) {
		super();
		this.capture = capture;
	}

	public Image() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getCapture() {
		return capture;
	}

	public void setCapture(byte[] capture) {
		this.capture = capture;
	}

	
}
