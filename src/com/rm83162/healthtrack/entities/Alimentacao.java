package com.rm83162.healthtrack.entities;

import java.util.Date;

public class Alimentacao {

	private String nome;
	private Integer quantidade;
	private double calorias;
	private TipoAlimentacao tipoAlimentacao;
	private Date data;
	
	public Alimentacao(String nome, Integer quantidade, Date data, TipoAlimentacao tipoAlimentacao) {
		this.tipoAlimentacao = tipoAlimentacao;
		this.nome = nome;
		this.quantidade = quantidade;
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
	public double getCalorias() {
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
