package com.rm83162.healthtrack.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pressao {

	final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private Integer idPressao;
	private Integer idUsuario;
	private double sistolica;
	private double diastolica;
	private Date dataEdicao;
	private Date dataCriacao;


	public Pressao(Integer idPressao, Integer idUsuario, double sistolica, double diastolica, Date dataEdicao, Date dataCriacao) {
		this.idPressao = idPressao;
		this.idUsuario = idUsuario;
		this.sistolica = sistolica;
		this.diastolica = diastolica;
		this.dataEdicao = dataEdicao;
		this.dataCriacao = dataCriacao;
	}

	public Pressao(double sistolica, double diastolica) {
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}

	public Integer getIdPressao() {
		return idPressao;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public double getSistolica() {
		return sistolica;
	}
	public void setSistolica(double sistolica) {
		this.sistolica = sistolica;
	}
	public double getDiastolica() {
		return diastolica;
	}
	public void setDiastolica(double diastolica) {
		this.diastolica = diastolica;
	}

	public String statusPressao(int sistolica, int diastolica) {
		if (sistolica < 120 || diastolica < 80) {
			return "Press�o baixa";
		}
		else if (sistolica < 140 || diastolica < 90){
			return "Press�o normal";
		}
		else {
			return "Press�o alta";
		}
	}

	@Override
	public String toString(){
		return "Código da pressão: "
				+ getIdPressao()
				+ ", Código do usuário: "
				+ getIdUsuario()
				+ ", sistólica :"
				+ String.format("%.2f", getSistolica())
				+ ", diastólica :"
				+ String.format("%.2f", getDiastolica())
				+ ", data de criação :"
				+ dateFormat.format(getDataCriacao().getTime())
				+ ", data de edição: "
				+ dateFormat.format(getDataEdicao().getTime());

	}

}
