package com.act4new.backend.dto;


public class ImageDTO {

	private Long id;
	private byte[] capture;
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
