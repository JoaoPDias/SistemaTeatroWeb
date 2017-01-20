
package br.com.sistemaTeatroWeb.jdbc;

import java.sql.*;


public class ConnectionFactory {
    public Connection getConnection(){
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","1234");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    }

