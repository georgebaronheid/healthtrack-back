package com.rm83162.healthtrack.entities;

import java.util.Date;

public class Alimentacao {
	private String nome;
	private Integer quantidade;
	private Integer calorias;
	private Date data;
	
	public Alimentacao(String nome, Integer quantidade, Integer calorias, Date data) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.calorias = calorias;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getCalorias() {
		return calorias;
	}
	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
