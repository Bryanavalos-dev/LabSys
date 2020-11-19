/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuarios;

/**
 *
 * @author gerson
 */
public class LoginDao {
    String correo;
    String password;
    Usuarios usuario;

    public Usuarios getUsuario() {
        return usuario;
    }
    
    Conexion objConexion = new Conexion();
    Connection conexion;
    PreparedStatement comando;
    ResultSet resultado;

    public LoginDao(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
    
   public boolean login(){
        boolean exito = false;
        try{
            conexion = objConexion.getConexion();
            comando = conexion.prepareStatement("select usuarioId, u.nombre, telefono, correo, password, nacimiento, activo, idrol, r.nombre rol from usuarios u inner join roles r on  u.idRol = r.idroles where correo = '"+this.correo+"' and password = '"+this.password+"'");
            resultado = comando.executeQuery();
            if (resultado != null) {
                exito=true;
                resultado.next();
                usuario = new Usuarios();
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setUsuarioID(resultado.getInt("usuarioId"));
                usuario.setTelefono(resultado.getString("telefono"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setPassword(resultado.getString("password"));
                usuario.setNacimiento(resultado.getString("nacimiento"));
                usuario.setActivo(resultado.getLong("activo"));
                usuario.setIdrol(resultado.getLong("idrol"));
                usuario.setRol(resultado.getString("rol"));
            }
            
        }
        catch(Exception e){
        return exito;
        }
    
        return exito;
    }
    
    
    
}
