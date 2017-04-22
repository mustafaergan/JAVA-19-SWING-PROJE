package com.vektorel.telefonuygulamasi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int id;
	
	@Column(name = "ad_soyad")
	String adSoyad;
	
	String telefon;
	
	@Column(name = "gorusme_tipi")
	int gorusmeTipi;
	
	
	String mesaj;
	
	@Column(name = "gorusme_zamani")
	Date gorusmeZamani;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getGorusmeTipi() {
		return gorusmeTipi;
	}

	public void setGorusmeTipi(int gorusmeTipi) {
		this.gorusmeTipi = gorusmeTipi;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public Date getGorusmeZamani() {
		return gorusmeZamani;
	}

	public void setGorusmeZamani(Date gorusmeZamani) {
		this.gorusmeZamani = gorusmeZamani;
	}
}
