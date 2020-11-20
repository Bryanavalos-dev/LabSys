/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4progra3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Statement;


public class ConexionSql {
    Connection conexion = null;
    static ConexionSql instancia = null;
    
    public ConexionSql() throws Exception{
        //Se carga el controlador o proveedor de datos (DRIVERS)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String strConex = "jdbc:sqlserver://GERSON-D\\SQLEXPRESS:1433;databaseName=marcacion;user=sa;password=1234;";
        conexion=DriverManager.getConnection(strConex);
        
        
    }
    
    public static ConexionSql getInstancia() throws Exception{
        if (instancia==null) instancia=new ConexionSql();
        return instancia;
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
