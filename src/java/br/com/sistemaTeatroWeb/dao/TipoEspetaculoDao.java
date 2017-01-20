package br.com.sistemaTeatroWeb.dao;

import br.com.sistemaTeatroWeb.jdbc.ConnectionFactory;
import br.com.sistemaTeatroWeb.modelo.Apresentacao;
import br.com.sistemaTeatroWeb.modelo.TipoEspetaculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class TipoEspetaculoDao {

    private Connection connection;

   
     public TipoEspetaculoDao() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public TipoEspetaculo buscaId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipoespetaculo where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            TipoEspetaculo tipoespetaculo = null;
            while (rs.next()) {
                tipoespetaculo = new TipoEspetaculo();
                tipoespetaculo.setIdTipoEspetaculo(rs.getInt("idTipoEspetaculo"));
                tipoespetaculo.setNome(rs.getString("nome"));
                tipoespetaculo.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            stmt.close();
            return tipoespetaculo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Inclui(TipoEspetaculo tipoespetaculo) {

        String sql = "INSERT INTO tipoespetaculo"
                + "(nome,descricao)"
                + "VALUES(?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,tipoespetaculo.getNome());
            stmt.setString(2,tipoespetaculo.getDescricao());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void Altera(TipoEspetaculo tipoespetaculo) {

        String sql = "UPDATE tipoespetaculo SET"
                + "nome = ?,descricao = ?"
                + "WHERE idTipoEspetaculo = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,tipoespetaculo.getNome());
            stmt.setString(2,tipoespetaculo.getDescricao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Exclui(TipoEspetaculo tipoespetaculo) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("delete from tipoespetaculo where id=?");
            stmt.setInt(1, tipoespetaculo.getIdTipoEspetaculo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}
