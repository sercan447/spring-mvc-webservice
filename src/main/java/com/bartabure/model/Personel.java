package com.bartabure.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Personel {

	
	private int id;
	private String adi;
	
	public Personel() {}
	public Personel(int id, String adi) {
		super();
		this.id = id;
		this.adi = adi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	@Override
	public String toString() {
		return "Personel [id=" + id + ", adi=" + adi + "]";
	}
	
	
	
	
}
