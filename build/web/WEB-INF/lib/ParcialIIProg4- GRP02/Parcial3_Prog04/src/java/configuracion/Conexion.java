/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bryan
 */
public class Conexion {
    Connection conexion;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/grupo02"  ,"root","");            
        } catch (Exception e) {
            System.err.println("Error en la conexions: " + e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
