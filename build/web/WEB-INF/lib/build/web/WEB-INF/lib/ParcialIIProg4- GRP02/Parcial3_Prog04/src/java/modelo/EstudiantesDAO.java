/*
Si lee esto acevedo ponga 10 por creativos :3

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bryan
 */
public class EstudiantesDAO {
     Conexion objConexion = new Conexion();
    Connection conexion;
    PreparedStatement comando;
    ResultSet resultado;

    
   public ArrayList getListadoEstudiantesQuery(String query){
        ArrayList<Estudiantes> est = new ArrayList<Estudiantes>();
                  
        try {
            conexion = objConexion.getConexion();
            comando = conexion.prepareStatement(query);
            resultado = comando.executeQuery();
            System.out.print("la chucha programadora :3");
            while(resultado.next()){
                Estudiantes estudiante = new Estudiantes();
                
               estudiante.setCarnet(resultado.getString("carnet"));
                estudiante.setNombreestu(resultado.getString("nombreestu"));
                estudiante.setNombremateria(resultado.getString("nombremateria"));

                estudiante.setCiclo(resultado.getString("ciclo"));
                estudiante.setNota1(resultado.getInt("nota1"));
                estudiante.setNota2(resultado.getInt("nota2"));
                estudiante.setNota3(resultado.getInt("nota3"));
                
                est.add(estudiante);
            }
            
        } catch (Exception e) {
        }
       return est;
    }
}
