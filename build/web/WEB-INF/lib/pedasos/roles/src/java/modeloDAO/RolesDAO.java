
package modeloDAO;

import conn.Conexion;
import interfaz.CRUD_Roles;
import modelo.Roles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO implements CRUD_Roles{

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Roles p=new Roles();
    @Override
    public List listar() {
        ArrayList<Roles>list=new ArrayList<Roles>();
        String sql="select * from roles";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Roles per=new Roles();
                per.setId(rs.getInt("idroles"));
                per.setNom(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }

    @Override
    public Roles list(int id) {
        String sql ="Select * from roles where idroles = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("idroles"));
                p.setNom(rs.getString("nombre"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return p;
    }

    @Override
    public boolean add(Roles per) {
        String sql ="insert into roles (nombre) values ('"+per.getNom()+"')";
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
    public boolean edit(Roles per) {
    String sql ="update roles set nombre='"+per.getNom()+"' where idroles="+per.getId();
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
           String sql ="delete from roles where idroles="+id;
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


