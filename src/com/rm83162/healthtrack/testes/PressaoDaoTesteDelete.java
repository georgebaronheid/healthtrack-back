package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PressaoDAO;
import com.rm83162.healthtrack.entities.Pressao;

import java.sql.SQLException;
import java.util.List;

public class PressaoDaoTesteDelete {
    public static void main(String[] args) throws SQLException {
        PressaoDAO pressaoDAO = new PressaoDAO();

        System.out.println("Pressão id 2 existe:");
        System.out.println(pressaoDAO.getById(2));

        pressaoDAO.deleteById(2);

        System.out.println("Id 2 deletado");
        List<Pressao> lista = pressaoDAO.getAll();
        for (Pressao pressao : lista) {
            System.out.println(pressao);
        }
    }
}
