package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PressaoDAO;
import com.rm83162.healthtrack.entities.Pressao;

import java.sql.SQLException;

public class PressaoDaoTesteCadastro {

    public static void main(String[] args) throws SQLException {
        PressaoDAO pressaoDAO = new PressaoDAO();

        pressaoDAO.register(new Pressao(130, 90));

        pressaoDAO.register(new Pressao(160, 90));

        pressaoDAO.register(new Pressao(170, 90));

        pressaoDAO.register(new Pressao(180, 90));

        pressaoDAO.register(new Pressao(90, 90));

        pressaoDAO.register(new Pressao(130, 90));

    }

}
