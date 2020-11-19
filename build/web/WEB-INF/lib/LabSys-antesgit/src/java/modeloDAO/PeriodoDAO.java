
package modeloDAO;

import conn.Conexion;
import interfaz.CRUD_Periodo;
import modelo.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeriodoDAO implements CRUD_Periodo{

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Periodo p=new Periodo();
    @Override
    public List listar() {
        ArrayList<Periodo>list=new ArrayList<Periodo>();
        String sql="select * from periodo";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Periodo per=new Periodo();
                per.setId(rs.getInt("periodoid"));
                per.setNom(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }

    @Override
    public Periodo list(int id) {
        String sql ="Select * from periodo where periodoid = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("periodoid"));
                p.setNom(rs.getString("nombre"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return p;
    }

    @Override
    public boolean add(Periodo per) {
        String sql ="insert into periodo (nombre) values ('"+per.getNom()+"')";
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
    public boolean edit(Periodo per) {
    String sql ="update periodo set nombre='"+per.getNom()+"' where periodoid="+per.getId();
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
           String sql ="delete from periodo where periodoid="+id;
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


