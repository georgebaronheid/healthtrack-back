package com.rm83162.healthtrack.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Peso {

	final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


	private Integer idPeso;
	private Integer idUsuario;
	private double valorKg;
	private Date dataEdicao;
	private Date dataCriacao;

	public Peso(){}

	public Peso(double valorKg) {
		this.valorKg = valorKg;
	}

	public Peso(int idPeso, int idUsuario, double valorKg, Date dataEdicao, Date dataCriacao){
		this.idPeso = idPeso;
		this.idUsuario = idUsuario;
		this.valorKg = valorKg;
		this.dataEdicao = dataEdicao;
		this.dataCriacao = dataCriacao;
	}


	public Integer getIdPeso() {
		return idPeso;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public double getValorKg() {
		return valorKg;
	}

	public void setValorKg(double valorKg) {
		this.valorKg = valorKg;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Date dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Peso peso = (Peso) o;
		return idPeso.equals(peso.idPeso) &&
				idUsuario.equals(peso.idUsuario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPeso, idUsuario);
	}

	@Override
	public String toString(){
		return "Código do peso: "
				+ getIdPeso()
				+ ", Código do usuário: "
				+ getIdUsuario()
				+ ", peso :"
				+ String.format("%.2f", getValorKg())
				+ ", data de criação :"
				+ dateFormat.format(getDataCriacao().getTime())
				+ ", data de edição: "
				+ dateFormat.format(getDataEdicao().getTime());

	}
}
