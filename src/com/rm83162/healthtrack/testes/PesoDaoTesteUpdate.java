package com.rm83162.healthtrack.testes;

import com.rm83162.healthtrack.dao.PesoDAO;
import com.rm83162.healthtrack.entities.Peso;

import java.sql.SQLException;

public class PesoDaoTesteUpdate {
    public static void main(String[] args) throws SQLException {
        Peso peso = new Peso(99);

        PesoDAO pesoDAO = new PesoDAO();

//        pesoDAO.update(peso, 8);

//        System.out.println(pesoDAO.getById(20));


        pesoDAO.deleteById(20);

    }
}
