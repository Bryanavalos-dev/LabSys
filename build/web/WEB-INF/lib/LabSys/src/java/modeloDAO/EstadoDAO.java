
package modeloDAO;

import conn.Conexion;
import interfaz.CRUD_Estado;
import modelo.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements CRUD_Estado{

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Estado p=new Estado();
    @Override
    public List listar() {
        ArrayList<Estado>list=new ArrayList<Estado>();
        String sql="select * from estado";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Estado per=new Estado();
                per.setId(rs.getInt("estadoid"));
                per.setNom(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }

    @Override
    public Estado list(int id) {
        String sql ="Select * from estado where estadoid = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("estadoid"));
                p.setNom(rs.getString("nombre"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return p;
    }

    @Override
    public boolean add(Estado per) {
        String sql ="insert into estado (nombre) values ('"+per.getNom()+"')";
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
    public boolean edit(Estado per) {
    String sql ="update estado set nombre='"+per.getNom()+"' where estadoid="+per.getId();
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
           String sql ="delete from estado where estadoid="+id;
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


