package com.codoacodo.sergiojuarez.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO implements Validar{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    @Override
    public int validar(Persona per) {
        r=0;
        String sql="SELECT * FROM login WHERE user=? and pass=?";
        try{
            con=cn.getConection();
            ps=con.prepareStatement(sql);
            ps.setString(1,per.getUser());
            ps.setString(2,per.getPass());
            rs=ps.executeQuery();
            while(rs.next()){
                r=1;
                per.setUser(rs.getString("user"));
                per.setPass(rs.getString("pass"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            }catch (SQLException e){
                System.out.println("ERROR EN CONEXION");
                return 0;
        }
    }
}
