package com.rm83162.healthtrack.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rm83162.healthtrack.entities.Peso;
import com.rm83162.healthtrack.jdbc.HTrackDBManager;

public class PesoDAO {
	
	private Connection connection;


	/**
	 * Método que popula a tabela Peso para objetivo de teste
	 * @throws SQLException
	 */
	public void cargaInicialPeso() throws SQLException {
		double i = 50;
		do {
			register(new Peso(i));
			i++;
		} while (i < 70);
		System.out.println("Carga inicial feita com sucesso");

	}

	/**
	 * Método que cadastra um peso
	 * Como não há sistema de perfil parar ser associado a id de usuário o método atual
	 * considera por padrão o id do usuário como 1. Isto será alterado quando houver configuração
	 * de perfil para possibilitar a recuperação do id do usuário logado.
	 * Informações como data de registor e data de atualização são retiradas no sistema no momento de alteração
	 * @param peso
	 * @throws SQLException
	 */
	public void register(Peso peso) throws SQLException {
		PreparedStatement preparedStatement = null;

		try {
			connection = HTrackDBManager.obterConexao();
			connection.setAutoCommit(false);

			String sql = "INSERT INTO T_HT_PESO(ID_PESO, ID_USUARIO, VL_PESO, DT_EDICAO, DT_CRIACAO) VALUES (SEQ_HT_PESO.NEXTVAL, 1, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1,peso.getValorKg());
			java.sql.Date dataEdicao = new java.sql.Date(new java.util.Date().getTime());
			preparedStatement.setDate(2, dataEdicao);
			java.sql.Date dataCriacao = new java.sql.Date(new java.util.Date().getTime());
			preparedStatement.setDate(3,dataCriacao);

			preparedStatement.executeUpdate();
			connection.commit();



		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			try{
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				connection.close();
			}
		}
	}


	/**
	 * Atualização de informações de um determinado cadastro de peso
	 * @param peso
	 * @throws SQLException
	 */
	public void update(Peso peso, int idPeso) throws SQLException {
		PreparedStatement preparedStatement = null;

		try {
			connection = HTrackDBManager.obterConexao();
			connection.setAutoCommit(false);

			String sql = "UPDATE T_HT_PESO SET VL_PESO = ?, DT_EDICAO = ? WHERE ID_PESO = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, peso.getValorKg());
			java.sql.Date dataUpdate = new java.sql.Date(new java.util.Date().getTime());
			preparedStatement.setDate(2, dataUpdate);
			preparedStatement.setInt(3, idPeso);

			preparedStatement.executeUpdate();

			connection.commit();
			System.out.println("Atualização feita com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**busca de peso por ID
	 * @param idPeso
	 * @return
	 */
	public Peso getById(int idPeso){
		Peso peso = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = HTrackDBManager.obterConexao();
			preparedStatement = connection.prepareStatement("SELECT * FROM T_HT_PESO WHERE ID_PESO = ?");
			preparedStatement.setInt(1, idPeso);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				Integer idPesoBuscado = resultSet.getInt(1);
				Integer idUsuario = resultSet.getInt(2);
				double valorPeso = resultSet.getDouble(3);
				java.util.Date dataEdicao = resultSet.getDate(4);
				Date dataCriacao = resultSet.getDate(5);
				peso = new Peso(idPeso, idUsuario, valorPeso, dataEdicao, dataCriacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return peso;
	}

	/**
	 * Deleta um cadastro em função de um id de peso específico
	 * @param idPeso
	 * @throws SQLException
	 */
	public void deleteById(int idPeso) throws SQLException {
		PreparedStatement preparedStatement = null;

		try{
			connection = HTrackDBManager.obterConexao();
			connection.setAutoCommit(false);
			String sql = "DELETE FROM T_HT_PESO WHERE ID_PESO = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idPeso);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * Lista todos os pesos cadastrados
	 * @return
	 */
	public List<Peso> getAll(){
		List<Peso> lista = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = HTrackDBManager.obterConexao();

			String sql = "SELECT * FROM T_HT_PESO";
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				Integer idPeso = resultSet.getInt(1);
				Integer idUsuario = resultSet.getInt(2);
				double valorPeso = resultSet.getDouble(3);
				java.util.Date dataEdicao = resultSet.getDate(4);
				java.util.Date dataCriacao = resultSet.getDate(5);

				Peso peso = new Peso(idPeso, idUsuario, valorPeso, dataEdicao, dataCriacao);

				lista.add(peso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}
}
