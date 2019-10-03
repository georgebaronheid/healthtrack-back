package com.rm83162.healthtrack.entities;

import java.util.Date;

public class Atividades {
	public String nome;
	public String tipo;
	public Integer duracao;
	public Date data;
	
	public Atividades(String nome, String tipo, Integer duracao, Date data) {
		this.nome = nome;
		this.tipo = tipo;
		this.duracao = duracao;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}	
}
