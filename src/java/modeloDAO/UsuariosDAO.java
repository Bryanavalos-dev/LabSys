
package modeloDAO;

import conn.Conexion;
import interfaz.CRUD_Usuarios;
import modelo.Roles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuarios;

public class UsuariosDAO implements CRUD_Usuarios{

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuarios u=new Usuarios();
    
    @Override
    public List listar() {
        ArrayList<Usuarios>list=new ArrayList<Usuarios>();
        String sql="select usuarioId, u.nombre, telefono, correo, password, nacimiento, activo, idrol, r.nombre rol from usuarios u inner join roles r on  u.idRol = r.idroles";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                u=new Usuarios();
                u.setUsuarioID(rs.getInt("usuarioId"));
                u.setNombre(rs.getString("nombre"));
                
                u.setTelefono(rs.getString("telefono"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
                u.setNacimiento(rs.getString("nacimiento"));
                u.setActivo(rs.getLong("activo"));
                u.setIdrol(rs.getLong("idrol"));
                u.setRol(rs.getString("rol"));
                list.add(u);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }
 @Override
    public Usuarios list(int id){
        String sql ="select usuarioId, u.nombre, telefono, correo, password, nacimiento, activo, idrol, r.nombre rol from usuarios u inner join roles r on  u.idRol = r.idroles where periodoid = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                u.setNombre(rs.getString("nombre"));
                u.setUsuarioID(rs.getInt("usuarioId"));
                u.setTelefono(rs.getString("telefono"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
                u.setNacimiento(rs.getString("nacimiento"));
                u.setActivo(rs.getLong("activo"));
                u.setIdrol(rs.getLong("idrol"));
                u.setRol(rs.getString("rol"));
                
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return u;
    }

    @Override
    public boolean add(Usuarios per) {
        String sql ="insert into usuarios (nombre,telefono, correo, password, nacimiento,idRol,activo) values ('"
                +per.getNombre()+"','"+per.getTelefono()+"','"+per.getCorreo()+"','"+per.getPassword()+"','"
                +per.getNacimiento()+"','"+per.getIdrol()+"','"+per.getActivo()+"')";
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.err.println("Error"+e);
        }
        
        return false;   
    }

    @Override
    public boolean edit(Usuarios per) {
    String sql ="update periodo set nombre="
            + " where periodoid="+per.getUsuarioID();
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e){
                }
        return false;
    }

    @Override
    public boolean eliminar(int idus) {
           String sql ="delete from usuarios where usuarioid="+idus;
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e){
                }
        return false;
    }
    }