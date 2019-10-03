package entities;

import java.time.LocalDateTime;

public class Peso {
	private double valorKg;
	private LocalDateTime diaHora;
	
	public Peso(double valorKg, LocalDateTime diaHora) {
		this.valorKg = valorKg;
		this.diaHora = diaHora;
	}
	
	public double getValorKg() {
		return valorKg;
	}
	public void setValorKg(double valorKg) {
		this.valorKg = valorKg;
	}
	public LocalDateTime getDiaHora() {
		return diaHora;
	}
	public void setDiaHora(LocalDateTime diaHora) {
		this.diaHora = diaHora;
	}
}
