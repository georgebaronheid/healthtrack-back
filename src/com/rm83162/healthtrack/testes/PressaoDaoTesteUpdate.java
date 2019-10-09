package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PressaoDAO;
import com.rm83162.healthtrack.entities.Pressao;

import java.sql.SQLException;

public class PressaoDaoTesteUpdate {
    public static void main(String[] args) throws SQLException {
        PressaoDAO pressaoDAO = new PressaoDAO();

        Pressao pressao = pressaoDAO.getById(2);

        System.out.println("Objeto antigo: " + pressao);
        pressao.setDiastolica(200);

        pressaoDAO.update(pressao);

        System.out.println("Objeto novo: ");
        System.out.println(pressaoDAO.getById(2));
    }
}
