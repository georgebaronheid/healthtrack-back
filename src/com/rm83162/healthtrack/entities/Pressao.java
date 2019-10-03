package com.rm83162.healthtrack.entities;

import java.util.Date;

public class Pressao {
	private Integer sistolica;
	private Integer diastolica;
	private Date data;
	
	
	
	public Pressao(Integer sistolica, Integer diastolica, Date data) {
		this.sistolica = sistolica;
		this.diastolica = diastolica;
		this.data = data;
	}
	
	
	public Integer getSistolica() {
		return sistolica;
	}
	public void setSistolica(Integer sistolica) {
		this.sistolica = sistolica;
	}
	public Integer getDiastolica() {
		return diastolica;
	}
	public void setDiastolica(Integer diastolica) {
		this.diastolica = diastolica;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String statusPressao(int sistolica, int diastolica) {
		if (sistolica < 120 || diastolica < 80) {
			return "Pressão baixa";
		}
		else if (sistolica < 140 || diastolica < 90){
			return "Pressão normal";
		}
		else {
			return "Pressão alta";
		}
	}

}
