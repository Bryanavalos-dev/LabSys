/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;


import java.util.ArrayList;
import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Horario;
import java.util.List;
import interfaz.CRUD_Horario;



/**
 *
 * @author bryan
 */
public class HorarioDAO  implements CRUD_Horario{
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Horario h = new Horario();
    
    @Override
    public List listar() {
        ArrayList<Horario>list=new ArrayList<Horario>();
        String sql="select idhorario, lunes, martes, miercoles, jueves, viernes, sabado, domingo, hora_inicio, hora_fin, creado, l.nombre idlaboratorio, p.nombre periodo from horario h inner join laboratorios l on h.idlaboratorio = l.idlaboratorios inner join periodo p on h.periodo = p.periodoid order by idhorario";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Horario per=new Horario();
             
               per.setCodigo(rs.getInt("idhorario"));
               per.setLaboratorio(rs.getString("idlaboratorio"));
               per.setLunes(rs.getInt("lunes"));
               per.setMartes(rs.getInt("martes")); 
               per.setMiercoles(rs.getInt("miercoles"));
               per.setJueves(rs.getInt("jueves"));
               per.setViernes(rs.getInt("viernes"));
               per.setSabado(rs.getInt("sabado"));
               per.setDomingo(rs.getInt("domingo"));;
               per.setHorainicio(rs.getString("hora_inicio"));
               per.setHorafin(rs.getString("hora_fin"));
               per.setPeriodo(rs.getString("periodo"));
               per.setCreado(rs.getString("creado"));
               
               list.add(per);
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return list;
    }
   
    @Override
    public Horario list(int id) {
        String sql ="select idhorario, lunes, martes, miercoles, jueves, viernes, sabado, domingo, hora_inicio, hora_fin, creado, l.nombre idlaboratorio, p.nombre periodo from horario h inner join laboratorios l on h.idlaboratorio = l.idlaboratorios inner join periodo p on h.periodo = p.periodoid  where idhorario = " + id;
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               h.setCodigo(rs.getInt("idhorario"));
               h.setLaboratorio(rs.getString("idlaboratorio"));
               h.setLunes(rs.getInt("lunes"));
               h.setMartes(rs.getInt("martes")); 
               h.setMiercoles(rs.getInt("miercoles"));
               h.setJueves(rs.getInt("jueves"));
               h.setViernes(rs.getInt("viernes"));
               h.setSabado(rs.getInt("sabado"));
               h.setDomingo(rs.getInt("domingo"));;
               h.setHorainicio(rs.getString("hora_inicio"));
               h.setHorafin(rs.getString("hora_fin"));
               h.setPeriodo(rs.getString("periodo"));
               h.setCreado(rs.getString("creado"));
            }
        } catch (Exception e){
            System.err.println("Error"+e);
        }
        return h;
    }

    @Override
    public boolean add(Horario per) {
        String sql ="insert into horario (idlaboratorio,lunes,martes,miercoles,jueves,viernes,sabado,domingo,hora_inicio,hora_fin,periodo,creado) values ('"+per.getLaboratorio()+"','"+per.getLunes()+"',"
                + " '"+per.getMartes()+"','"+per.getMiercoles()+"','"+per.getJueves()+"','"+per.getViernes()+"','"+per.getSabado()+"','"+per.getDomingo()+"','"+per.getHorainicio()+"','"+per.getHorafin()+"',"
                + " '"+per.getPeriodo()+"','"+per.getCreado()+"',)";
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
    public boolean edit(Horario per) {
    String sql ="update periodo set idlaboratorio='"+per.getLaboratorio()+"',lunes='"+per.getLunes()+"',martes='"+per.getMartes()+"',"
            + "miercoles='"+per.getMiercoles()+"',jueves='"+per.getJueves()+"',viernes='"+per.getViernes()+"',"
            + "sabado='"+per.getSabado()+"',domingo='"+per.getDomingo()+"',hora_inicio='"+per.getHorainicio()+"',hora_fin='"+per.getHorafin()+"',"
            + "periodo='"+per.getPeriodo()+"',creado='"+per.getCreado()+"' where idhorario="+per.getCodigo();
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
           String sql ="delete from horario where idhorario="+id;
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



  

