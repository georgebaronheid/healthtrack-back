package com.rm83162.healthtrack.dao;

import com.rm83162.healthtrack.entities.Pressao;
import com.rm83162.healthtrack.jdbc.HTrackDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PressaoDAO {

    private Connection connection;

    /**
     *
     * @param pressao
     * @throws SQLException
     */
    public void register(Pressao pressao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String statementSQL = "INSERT INTO T_HT_PRESSAO (ID_PRESSAO, ID_USUARIO, VL_SISTOLICA, VL_DIASTOLICA, DT_EDICAO, DT_CRIACAO) VALUES (SEQ_HT_PRESSAO.NEXTVAL, 1, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(statementSQL);
            preparedStatement.setDouble(1, pressao.getSistolica());
            preparedStatement.setDouble(2, pressao.getDiastolica());
            preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));

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
                connection.close();
            }
        }
    }

    /**
     *
     * @param pressao
     * @param idPressao
     * @throws SQLException
     */
    public void update(Pressao pressao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String statementSQL = "UPDATE T_HT_PRESSAO SET VL_SISTOLICA= ? , VL_DIASTOLICA= ? , DT_EDICAO= ? " +
                    "WHERE ID_PRESSAO= ?";
            preparedStatement = connection.prepareStatement(statementSQL);
            preparedStatement.setDouble(1, pressao.getSistolica());
            preparedStatement.setDouble(2, pressao.getDiastolica());
            preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setInt(4, pressao.getIdPressao());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
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
     *
     * @param idPressao
     * @return
     */
    public Pressao getById(int idPressao) {
        Pressao pressao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = HTrackDBManager.obterConexao();
            preparedStatement = connection.prepareStatement("SELECT * FROM T_HT_PRESSAO WHERE ID_PRESSAO = ?");
            preparedStatement.setInt(1, idPressao);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Integer idPressaoBuscado = resultSet.getInt(1);
                Integer idUsuario = resultSet.getInt(2);
                double valorSistolica = resultSet.getInt(3);
                double valorDiastolica = resultSet.getInt(4);
                java.util.Date dataEdicao = resultSet.getDate(5);
                java.util.Date dataCriacao = resultSet.getDate(6);
                pressao = new Pressao(idPressaoBuscado, idUsuario, valorSistolica, valorDiastolica, dataEdicao, dataCriacao);
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
        return pressao;
    }


    /**
     *
     * @return
     */
    public List<Pressao> getAll(){
        List<Pressao> lista = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = HTrackDBManager.obterConexao();

            String statementSQL = "SELECT * FROM T_HT_PRESSAO";
            preparedStatement = connection.prepareStatement(statementSQL);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idPressao = resultSet.getInt(1);
                Integer idUsuario = resultSet.getInt(2);
                double valorSistolica = resultSet.getDouble(3);
                double valorDiastolica = resultSet.getDouble(4);
                java.util.Date dataEdicao = resultSet.getDate(5);
                java.util.Date dataCriacao = resultSet.getDate(6);

                Pressao pressao = new Pressao(idPressao, idUsuario, valorSistolica, valorDiastolica, dataEdicao, dataCriacao);

                lista.add(pressao);
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

    /**
     *
     * @param idPressao
     * @throws SQLException
     */
    public void deleteById(int idPressao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String statementSQL = "DELETE FROM T_HT_PRESSAO WHERE ID_PRESSAO = ?";
            preparedStatement = connection.prepareStatement(statementSQL);

            preparedStatement.setInt(1, idPressao);
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
}
