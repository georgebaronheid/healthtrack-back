package com.rm83162.healthtrack.testes;

import java.time.LocalDateTime;
import java.util.*;

import com.rm83162.healthtrack.dao.PesoDAO;
import com.rm83162.healthtrack.entities.Peso;

public class PesoDaoTeste {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("pt", "BR"));
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		PesoDAO pesoDao = new PesoDAO();
		
		List<Peso> pesos = new ArrayList<>();
		
		
		for (int i = 0; i < 10; i++){
			System.out.println();
			System.out.printf("Digite o valor do peso em kg da medição %s: ", i + 1);
			double peso = sc.nextDouble();
			Date data = LocalDateTime.now();
			pesos.add(new Peso(peso, data));
		}
		
		pesoDao.getAll(pesos);
		
		
		
		sc.close();
	}

}
