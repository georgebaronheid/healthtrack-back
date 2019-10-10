package com.rm83162.healthtrack.dao;

import com.rm83162.healthtrack.entities.TipoAlimentacao;
import com.rm83162.healthtrack.jdbc.HTrackDBManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TipoAlimentacaoDAO {

    private Connection connection;

    /**
     *
     * @param tipoAlimentacao
     * @throws SQLException
     */
    public void register(TipoAlimentacao tipoAlimentacao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try{
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String SQLStatement = "INSERT INTO T_HT_TIPOREF (ID_TIPOALIM, VL_CALORQTD, DS_DESCRICAO) VALUES(SEQ_HT_TP_REF.NEXTVAL, ?, '?')";
            preparedStatement = connection.prepareStatement(SQLStatement);
            preparedStatement.setDouble(1, tipoAlimentacao.getValorCaloriaPorKg());
            preparedStatement.setString(2, tipoAlimentacao.getDescricao());

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
            }
        }
    }

    /**
     *
     * @param tipoAlimentacao
     * @throws SQLException
     */
    public void update(TipoAlimentacao tipoAlimentacao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String SQLStatement = "UPDATE T_HT_TIPOREF SET VL_CALORQTD=?, DS_DESCRICAO='?' " +
                    "WHERE ID_TIPOALIM=?;";

            preparedStatement = connection.prepareStatement(SQLStatement);
            preparedStatement.setDouble(1, tipoAlimentacao.getValorCaloriaPorKg());
            preparedStatement.setString(2, tipoAlimentacao.getDescricao());
            preparedStatement.setInt(3, tipoAlimentacao.getIdTipoAlimentacao());

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
     * @return
     */
    public List<TipoAlimentacao> getAll() {
        List<TipoAlimentacao> lista = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = HTrackDBManager.obterConexao();

            String SQLStatement = "SELECT * FROM T_HT_TIPOREF;";
            preparedStatement = connection.prepareStatement(SQLStatement);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idTipoAlimentacao = resultSet.getInt(1);
                double valorCaloria = resultSet.getDouble(2);
                String descricao = resultSet.getString(3);

                TipoAlimentacao tipoAlimentacao = new TipoAlimentacao(idTipoAlimentacao, descricao, valorCaloria);

                lista.add(tipoAlimentacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;

    }

    /**
     *
     * @param idTipoAlimentacao
     * @return
     */
    public TipoAlimentacao getById(int idTipoAlimentacao){
        TipoAlimentacao tipoAlimentacao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = HTrackDBManager.obterConexao();
            preparedStatement = connection.prepareStatement("SELECT ID_TIPOALIM, VL_CALORQTD, DS_DESCRICAO" +
                    " FROM T_HT_TIPOREF WHERE ID_TIPOALIM = ?;");
            preparedStatement.setInt(1, idTipoAlimentacao);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Integer idTipALim = resultSet.getInt(1);
                Double valorCaloria = resultSet.getDouble(2);
                String descricao = resultSet.getString(3);
                tipoAlimentacao = new TipoAlimentacao(idTipALim, descricao, valorCaloria);
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
        return tipoAlimentacao;
    }

    /**
     *
     * @param idTipoAlimentacao
     * @throws SQLException
     */
    public void delete(int idTipoAlimentacao) throws SQLException {
        PreparedStatement preparedStatement = null;

        try{
            connection = HTrackDBManager.obterConexao();
            String SQLStatement = "DELETE FROM T_HT_TIPOREF WHERE ID_TIPOALIM = ?";
            preparedStatement = connection.prepareStatement(SQLStatement);
            preparedStatement.setInt(1, idTipoAlimentacao);

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
