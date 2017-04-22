package com.vektorel.telefonuygulamasi.enums;

public enum GorusmeTipi {
	YUZ_YUZE(1,"Yüz yüze"),
	TELEFON(2,"Telefon");
	
	int id;
	String value;
	
	GorusmeTipi(int id, String value){
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}

}
