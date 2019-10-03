package dao;

import java.util.List;

import entities.Peso;
import java.time.format.DateTimeFormatter;

public class PesoDAO {
	

	
	public PesoDAO(){
		super();
	}
	
	public void getAll(List<Peso> peso){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		if (peso.size() > 0){
			for (Peso pesos : peso){
				System.out.println("Foi salvo as " + pesos.getDiaHora().format(formatter) + " horas e o peso foi " + pesos.getValorKg() + " quilogramas"); 
			}
		}
		else {
			System.out.println("Não há listagens de peso para retornar");
		}
	}
}
