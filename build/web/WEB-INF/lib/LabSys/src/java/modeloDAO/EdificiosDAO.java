/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;


import conn.Conexion;
import interfaz.CRUD_Edificios;
import modelo.Edificios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author bryan
 */
public class EdificiosDAO implements CRUD_Edificios{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Edificios p=new Edificios();
    
    @Override
    public List listar() {
        ArrayList<Edificios>list=new ArrayList<Edificios>();
        String sql="select * from edificios";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Edificios per=new Edificios();
                per.setId(rs.getInt("idedificios"));
                per.setNombre(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }

    @Override
    public Edificios list(int id) {
        String sql ="Select * from edificios where idedificios = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("idedificios"));
                p.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return p;
    }

    @Override
    public boolean add(Edificios per) {
        String sql ="insert into edificios (nombre) values ('"+per.getNombre()+"')";
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
    public boolean edit(Edificios per) {
    String sql ="update edificios set nombre='"+per.getNombre()+"' where idedificios="+per.getId();
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
    public boolean eliminar(int id) {
           String sql ="delete from edificios where idedificios="+id;
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
