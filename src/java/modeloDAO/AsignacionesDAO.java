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
import java.util.ArrayList;
import java.util.List;
import modelo.Asignaciones;


/**
 *
 * @author gerson
 */
public class AsignacionesDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Asignaciones asignaciones;
    
    public List listar() {
        ArrayList<Asignaciones>list=new ArrayList<Asignaciones>();
        String sql="select a.asignacionid, a.laboratorioid, a.usuarioid, l.nombre as laboratorio, u.nombre usuario from asignaciones a inner join laboratorios l on a.laboratorioid = l.idlaboratorios inner join usuarios u on a.usuarioid = u.usuarioId";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Asignaciones per=new Asignaciones();
                per.setAsignacionid(rs.getInt("asignacionid"));
                per.setLaboratorioid(rs.getInt("laboratorioid"));
                per.setUsuarioid(rs.getInt("usuarioid"));
                per.setLaboratorio(rs.getString("laboratorio"));
                per.setUsuario(rs.getString("usuario"));
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }
    
    
    public Asignaciones list(int id) {
        String sql ="select a.asignacionid, a.laboratorioid, a.usuarioid, l.nombre as laboratorio, u.nombre usuario from asignaciones a inner join laboratorios l on a.laboratorioid = l.idlaboratorios inner join usuarios u on a.usuarioid = u.usuarioId where asignacionid = '"+id+"'";
        Asignaciones per=new Asignaciones();
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                per.setAsignacionid(rs.getInt("asignacionid"));
                per.setLaboratorioid(rs.getInt("laboratorioid"));
                per.setUsuarioid(rs.getInt("usuarioid"));
                per.setLaboratorio(rs.getString("laboratorio"));
                per.setUsuario(rs.getString("usuario"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return per;
    }

    public boolean add(Asignaciones per) {
        String sql ="insert into asignaciones (laboratorioid, usuarioid) values ('"+per.getLaboratorioid()+"','"+per.getUsuarioid()+"')";
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e){
        }
        return false;   
    }

    public boolean edit(Asignaciones per) {
    String sql ="update asignaciones set laboratorioid='"+per.getLaboratorioid()+"', usuarioid='"+per.getUsuarioid()+"' where asignacionid="+per.getAsignacionid();
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (Exception e){
                }
        return false;
    }

    
    public boolean eliminar(int id) {
           String sql ="delete from asignaciones where asignacionid="+id;
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
    
    
    
    
    
}
