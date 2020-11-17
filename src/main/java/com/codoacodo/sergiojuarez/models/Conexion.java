package com.codoacodo.sergiojuarez.models;

import java.sql.*;

public class Conexion {
    public Connection getConection() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Conectado correctamente a la Base de Datos");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: "+e);
        } catch (SQLException e) {
            System.out.println("Error de conexion: "+e);
        } catch (Exception e) {
            System.out.println("Error desconocido: "+e);
        }
            return null;
    }
}