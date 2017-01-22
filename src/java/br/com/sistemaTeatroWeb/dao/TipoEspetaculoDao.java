package br.com.sistemaTeatroWeb.dao;

import br.com.sistemaTeatroWeb.jdbc.ConnectionFactory;
import br.com.sistemaTeatroWeb.modelo.TipoEspetaculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class TipoEspetaculoDao {

    private Connection connection;

   
     public TipoEspetaculoDao() {
        this.connection = new ConnectionFactory().getConnection();
      

    }
     public int getIdTipoEspetaculo()
     {
         int id;
         try {
            PreparedStatement stmt = this.connection.prepareStatement("SHOW TABLE STATUS LIKE 'tipoespetaculo'");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("Auto_increment");
         } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         
     return id;
     }

    public TipoEspetaculo buscaId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipoespetaculo where idTipoEspetaculo = ?");
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
            System.out.println("Inclusão realizada com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void Altera(TipoEspetaculo tipoespetaculo) {

        String sql = "UPDATE tipoespetaculo SET "
                + "nome = ?,descricao = ?"
                + " WHERE idTipoEspetaculo = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,tipoespetaculo.getNome());
            stmt.setString(2,tipoespetaculo.getDescricao());
            stmt.setInt(3, tipoespetaculo.getIdTipoEspetaculo());
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();
            System.out.println("Alteração realizada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Exclui(TipoEspetaculo tipoespetaculo) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("delete from tipoespetaculo where idTipoEspetaculo=?");
            stmt.setInt(1, tipoespetaculo.getIdTipoEspetaculo());
            System.out.println("Exclusão realizada com sucesso");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}
