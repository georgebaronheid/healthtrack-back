package com.rm83162.healthtrack.entities;

public class TipoAtividade {

    public double idTipoAtividade;
    public double valorCaloriaMinutos;
    public String descricao;

    public TipoAtividade(){}

    public TipoAtividade(double idTipoAtividade, double valorCaloriaMinutos, String descricao) {
        this.idTipoAtividade = idTipoAtividade;
        this.valorCaloriaMinutos = valorCaloriaMinutos;
        this.descricao = descricao;
    }

    public double getIdTipoAtividade() {
        return idTipoAtividade;
    }

    public double getValorCaloriaMinutos() {
        return valorCaloriaMinutos;
    }

    public void setValorCaloriaMinutos(double valorCaloriaMinutos) {
        this.valorCaloriaMinutos = valorCaloriaMinutos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
