package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PesoDAO;
import com.rm83162.healthtrack.entities.Peso;

import java.util.List;

public class PesoDaoTesteListagem {
    public static void main(String[] args) {
        PesoDAO pesoDAO = new PesoDAO();
        List<Peso> todosPesos = pesoDAO.getAll();

        for(Peso pesos : todosPesos) {
            System.out.println(pesos);
        }


    }
}
