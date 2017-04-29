package com.vektorel.telefonuygulamasi.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SorgulaEntity {
	String adSoyad;
	Date basTarihi;
	Date bitisTarihi;
	int type;
	
	public Date convertStringToDate(String date){
		if(date.equals("  -  -    "))
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date basTarihDate = null;
		try {
			basTarihDate = formatter.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return basTarihDate;
	}
	
	
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public Date getBasTarihi() {
		return basTarihi;
	}
	public void setBasTarihi(String basTarihi) {
		this.basTarihi = convertStringToDate(basTarihi);
	}
	public Date getBitisTarihi() {
		return bitisTarihi;
	}
	public void setBitisTarihi(String bitisTarihi) {
		this.bitisTarihi = convertStringToDate(bitisTarihi);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	

}
