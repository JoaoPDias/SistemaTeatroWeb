/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaTeatroWeb.dao;

import br.com.sistemaTeatroWeb.jdbc.ConnectionFactory;
import br.com.sistemaTeatroWeb.modelo.Apresentacao;
import br.com.sistemaTeatroWeb.modelo.Sala;
import java.sql.*;
import org.joda.time.*;

public class ApresentacaoDao {

    private Connection connection;

    public ApresentacaoDao() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public Apresentacao buscaId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from apresentacao where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Apresentacao apresentacao = null;
            while (rs.next()) {
                apresentacao = new Apresentacao();
                apresentacao.setIdApresentacao(rs.getInt("idApresentacao"));
                apresentacao.setData(new DateTime(rs.getDate("data")));
                apresentacao.setHorario(new LocalTime(rs.getTime("horario").getTime()));
                apresentacao.setFk_Sala(new SalaDao().getSala(rs.getInt("fk_Sala")));
                apresentacao.setValorIngresso(rs.getDouble("valorIngresso"));
                apresentacao.setFk_Espetaculo(new EspetaculoDao().getEspetaculo(rs.getInt("fk_Espetaculo")));

            }
            rs.close();
            stmt.close();
            return apresentacao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Inclui(Apresentacao apresentacao) {

        String sql = "INSERT INTO apresentacao"
                + "(data,horario,fk_Sala,valorIngresso,fk_Espetaculo)"
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setDate(1, new Date(apresentacao.getData().getMillis()));
            stmt.setTime(2, new Time(apresentacao.getHorario().toDateTimeToday().getMillis()));
            stmt.setInt(3, apresentacao.getFk_Sala().getIdSala());
            stmt.setDouble(4, apresentacao.getValorIngresso());
            stmt.setInt(5, apresentacao.getFk_Espetaculo().getIdEspetaculo());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void Altera(Apresentacao apresentacao) {

        String sql = "UPDATE apresentacao SET"
                + "data = ?,horario = ?,fk_Sala = ?,valorIngresso = ?,fk_Espetaculo = ?"
                + "WHERE idApresentacao = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setDate(1, new Date(apresentacao.getData().getMillis()));
            stmt.setTime(2, new Time(apresentacao.getHorario().toDateTimeToday().getMillis()));
            stmt.setInt(3, apresentacao.getFk_Sala().getIdSala());
            stmt.setDouble(4, apresentacao.getValorIngresso());
            stmt.setInt(5, apresentacao.getFk_Espetaculo().getIdEspetaculo());
            stmt.setInt(6, apresentacao.getIdApresentacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Exclui(Apresentacao apresentacao) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("delete from apresentacao where id=?");
            stmt.setLong(1, apresentacao.getIdApresentacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


       

    

