package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PressaoDAO;
import com.rm83162.healthtrack.entities.Pressao;

import java.util.List;

public class PressaoDaoTesteListagem {
    public static void main(String[] args) {
        PressaoDAO pressaoDAO = new PressaoDAO();

        List<Pressao> todasPressoes = pressaoDAO.getAll();

        for (Pressao pressao : todasPressoes){
            System.out.println(pressao);
        }

        System.out.println("Busca por id: 2");
        System.out.println(pressaoDAO.getById(2));
    }
}
