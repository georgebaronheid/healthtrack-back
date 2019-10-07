package com.rm83162.healthtrack.entities;

public class TipoAlimentacao {

    public double idTipoAlimentacao;
    public String descricao;
    public double valorCaloriaPorKg;

    public TipoAlimentacao(){}

    public TipoAlimentacao(double idTipoAlimentacao, String descricao, double valorCaloriaPorKg) {
        this.idTipoAlimentacao = idTipoAlimentacao;
        this.descricao = descricao;
        this.valorCaloriaPorKg = valorCaloriaPorKg;
    }

    public double getIdTipoAlimentacao() {
        return idTipoAlimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCaloriaPorKg() {
        return valorCaloriaPorKg;
    }

    public void setValorCaloriaPorKg(double valorCaloriaPorKg) {
        this.valorCaloriaPorKg = valorCaloriaPorKg;
    }
}
