/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;
import conn.Conexion;
import interfaz.CRUD_Laboratorios;
import modelo.Laboratorios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class LaboratoriosDAO implements CRUD_Laboratorios{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Laboratorios l=new Laboratorios();
    
    @Override
    public List listar() {
        ArrayList<Laboratorios>list=new ArrayList<Laboratorios>();
        String sql="select idlaboratorios, l.nombre, e.nombre idedificio, nivel, aula, direccion,telefono from laboratorios l inner join edificios e on l.edificioid = e.idedificios order by idlaboratorios";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               Laboratorios per=new Laboratorios();
               per.setCodigo(rs.getInt("idlaboratorios"));
               per.setNombre(rs.getString("nombre"));
               per.setEdificio(rs.getString("idedificio"));
               per.setNivel(rs.getString("nivel"));
               per.setAula(rs.getString("aula"));
               per.setDireccion(rs.getString("direccion")); 
               per.setTelefono(rs.getString("telefono")); 
               
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }
     @Override
    public Laboratorios list(int id) {
        String sql ="select idlaboratorios, l.nombre, e.nombre idedificios,edificioid, nivel, aula, direccion,telefono from laboratorios l inner join edificios e on l.edificioid = e.idedificios  where idlaboratorios = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               l.setCodigo(rs.getInt("idlaboratorios"));
               l.setNombre(rs.getString("nombre"));
               l.setEdificio(rs.getString("idedificios"));
               l.setEdificios(rs.getInt("edificioid"));
               l.setNivel(rs.getString("nivel"));
               l.setAula(rs.getString("aula"));
               l.setDireccion(rs.getString("direccion")); 
               l.setTelefono(rs.getString("telefono")); 
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return l;
    }

    @Override
    public boolean add(Laboratorios per) {
        String sql ="insert into laboratorios (nombre, edificioid,nivel,aula,direccion,telefono) values ('"+per.getNombre()+"','"+per.getEdificios()+"','"
               +per.getNivel()+"','"+per.getAula()+"','"+per.getDireccion()+"','"+per.getTelefono()+"')";
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
    public boolean edit(Laboratorios per) {
    String sql ="update laboratorios set nombre='"+per.getNombre()+"',edificioid='"+per.getEdificios()+"',nivel='"+per.getNivel()+"',"
            + "aula='"+per.getAula()+"',direccion='"+per.getDireccion()+"',telefono='"+per.getTelefono()+"' where idlaboratorios="+per.getCodigo();
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
    public boolean eliminar(int ides) {
           String sql ="delete from laboratorios where idlaboratorios="+ides;
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
