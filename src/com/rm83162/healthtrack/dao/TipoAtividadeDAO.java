package com.rm83162.healthtrack.dao;

import com.rm83162.healthtrack.entities.Peso;
import com.rm83162.healthtrack.entities.TipoAlimentacao;
import com.rm83162.healthtrack.entities.TipoAtividade;
import com.rm83162.healthtrack.jdbc.HTrackDBManager;

import java.sql.*;
import java.util.List;

public class TipoAtividadeDAO {

    private Connection connection;

    /**
     *
     * @param tipoAtividade
     * @throws SQLException
     */
    public void register(TipoAtividade tipoAtividade) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO T_HT_TIPATIV " +
                    "(ID_TIPOATIV, DS_DESCRICAO, VL_CALORMIN) " +
                    "VALUES(SEQ_HT_TP_ATIV.NEXTVAL, '?', ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tipoAtividade.getDescricao());
            preparedStatement.setDouble(2, tipoAtividade.getValorCaloriaMinutos());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
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
     * @param tipoAtividade
     * @throws SQLException
     */
    public void update(TipoAtividade tipoAtividade) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            connection = HTrackDBManager.obterConexao();
            connection.setAutoCommit(false);

            String sql = "UPDATE T_HT_TIPATIV SET DS_DESCRICAO = '?', VL_CALORMIN = ? WHERE ID_TIPOATIV = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipoAtividade.getDescricao());
            preparedStatement.setDouble(2, tipoAtividade.getValorCaloriaMinutos());

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


    /**
     *
     * @param idTipoAtividade
     * @return
     */
    public TipoAtividade getById(int idTipoAtividade){
        TipoAtividade tipoAtividade = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = HTrackDBManager.obterConexao();
            preparedStatement = connection.prepareStatement("SELECT * FROM T_HT_TIPATIV WHERE ID_TIPOATIV = ?");
            preparedStatement.setInt(1, idTipoAtividade);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Integer idTipoAtiv = resultSet.getInt(1);
                String descricao = resultSet.getString(2);
                double valorCaloria = resultSet.getDouble(3);
                tipoAtividade = new TipoAtividade(idTipoAtividade, valorCaloria, descricao);
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

        return tipoAtividade;
    }


    /**
     *
     * @return
     */
    public List<TipoAtividade> getAll() {
        List<TipoAtividade> lista = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = HTrackDBManager.obterConexao();

            String SQLStatement = "SELECT * FROM T_HT_TIPATIV;";
            preparedStatement = connection.prepareStatement(SQLStatement);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idTipoAtiv = resultSet.getInt(1);
                double valorCaloria = resultSet.getDouble(2);
                String descricao = resultSet.getString(3);

                TipoAtividade tipoAtividade = new TipoAtividade(idTipoAtiv, valorCaloria, descricao);

                lista.add(tipoAtividade);
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
     * @param idTipoAtividade
     * @throws SQLException
     */
    public void delete(int idTipoAtividade) throws SQLException {
        PreparedStatement preparedStatement = null;

        try{
            connection = HTrackDBManager.obterConexao();
            String SQLStatement = "DELETE FROM T_HT_TIPATIV WHERE ID_TIPOATIV = ?";
            preparedStatement = connection.prepareStatement(SQLStatement);
            preparedStatement.setInt(1, idTipoAtividade);

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
