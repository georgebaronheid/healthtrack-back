package com.rm83162.healthtrack.entities;

import java.util.Date;

public class Usuario {
	private String nome;
	private String email;
	private Integer senha;
	private Date dataNasc;
	private Double peso;
	private char sexo;
	private Double altura;
	
	public Usuario(String nome, String email, Integer senha, Date dataNasc, Double peso, char sexo, Double altura) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.peso = peso;
		this.sexo = sexo;
		this.altura = altura;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getSenha() {
		return senha;
	}
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
}
