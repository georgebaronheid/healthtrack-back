package com.rm83162.healthtrack.testes;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import com.rm83162.healthtrack.dao.PesoDAO;
import com.rm83162.healthtrack.entities.Peso;

public class PesoDaoTesteCadastro {

	public static void main(String[] args) throws SQLException {

		//Declara��o
		PesoDAO pesoDAO = new PesoDAO();

		//Documentação do método em dao.PesoDAO
		pesoDAO.register(new Peso(65.5));

		//Método que popula a tabela Peso de utilizando loop
		pesoDAO.cargaInicialPeso();
	}
}


