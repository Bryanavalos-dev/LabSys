
package modeloDAO;

import conn.Conexion;
import modelo.Limpieza;
//import Modelo.LimpiezaPro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import interfaz.CRUD_Limpieza;

public class LimpiezaDAO implements CRUD_Limpieza{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Limpieza l = new Limpieza();
    
    @Override
    public List listar() {
        ArrayList<Limpieza>list = new ArrayList<>();
        String sql = "SELECT *,es.nombre estados FROM limpieza li INNER JOIN (SELECT idhorario, idlaboratorio, lunes, martes, miercoles, jueves, viernes, sabado, domingo, hora_inicio, hora_fin, p.nombre periodo, l.nombre laboratorio FROM horario h INNER JOIN laboratorios l ON h.idlaboratorio = l.idlaboratorios INNER JOIN periodo p ON h.periodo = p.periodoid) h ON li.horarioid = h.idhorario INNER JOIN usuarios u ON li.usuarioid = u.usuarioId inner join estado es on li.estado = es.estadoid order by limpiezaid";
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Limpieza limp = new Limpieza();
                limp.setLimpiezaid(rs.getInt("limpiezaid"));
                l.setIdhorario(rs.getInt("idhorario"));
                limp.setHorarioid(rs.getInt("idhorario"));
                limp.setEstado(rs.getInt("estado"));
                limp.setEstadoid(rs.getString("estados"));
                limp.setNombre(rs.getString("nombre"));
                limp.setLunes(rs.getInt("lunes"));
                limp.setMartes(rs.getInt("martes"));
                limp.setMiercoles(rs.getInt("miercoles"));
                limp.setJueves(rs.getInt("jueves"));
                limp.setViernes(rs.getInt("viernes"));
                limp.setSabado(rs.getInt("sabado")); 
                limp.setDomingo(rs.getInt("domingo"));
                limp.setFecha_inicio(rs.getString("fecha_inicio"));
                limp.setFecha_final(rs.getString("fecha_final"));
                limp.setHoraInicio(rs.getString("hora_inicio"));
                limp.setHoraFin(rs.getString("hora_fin"));
                limp.setPerdiodo(rs.getString("periodo"));
                limp.setLaboratorio(rs.getString("laboratorio"));
                list.add(limp);
                
            }
        } catch (Exception e){
                System.err.println("Error"+e);
        }
        return list;
    }

    @Override
    public Limpieza list(int limpiezaid) {
        String sql = "SELECT *,es.nombre estados FROM limpieza li INNER JOIN (SELECT idhorario, idlaboratorio, lunes, martes, miercoles, jueves, viernes, sabado, domingo, hora_inicio, hora_fin, p.nombre periodo, l.nombre laboratorio FROM horario h INNER JOIN laboratorios l ON h.idlaboratorio = l.idlaboratorios INNER JOIN periodo p ON h.periodo = p.periodoid) h ON li.horarioid = h.idhorario INNER JOIN usuarios u ON li.usuarioid = u.usuarioId inner join estado es on li.estado = es.estadoid where  limpiezaid="+limpiezaid;;
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                l.setIdhorario(rs.getInt("idhorario"));
                l.setUsuarioid(rs.getInt("usuarioid"));
                l.setLimpiezaid(rs.getInt("limpiezaid"));
                l.setHorarioid(rs.getInt("idhorario"));
                l.setEstado(rs.getInt("estado"));
                l.setEstadoid(rs.getString("estados"));
                l.setNombre(rs.getString("nombre"));
                l.setLunes(rs.getInt("lunes"));
                l.setMartes(rs.getInt("martes"));
                l.setMiercoles(rs.getInt("miercoles"));
                l.setJueves(rs.getInt("jueves"));
                l.setViernes(rs.getInt("viernes"));
                l.setSabado(rs.getInt("sabado")); 
                l.setDomingo(rs.getInt("domingo"));
                l.setFecha_inicio(rs.getString("fecha_inicio"));
                l.setFecha_final(rs.getString("fecha_final"));
                l.setHoraInicio(rs.getString("hora_inicio"));
                l.setHoraFin(rs.getString("hora_fin"));
                l.setPerdiodo(rs.getString("periodo"));
                l.setLaboratorio(rs.getString("laboratorio"));
                
                
                
            }
        } catch (Exception e){
            System.err.println("Error"+e);
                
        }
        return l;
    }

    @Override
    public boolean add(Limpieza limp) {
        String sql = "insert into Limpieza (horarioid, usuarioid, fecha_inicio, fecha_final, estado) values ('"+limp.getIdhorario()+"','"+limp.getUsuarioid()+"','"+limp.getFecha_inicio()+"','"+limp.getFecha_final()+"','"+limp.getEstado()+"')";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }

    @Override
    public boolean edit(Limpieza limp) {
        String sql = "update Limpieza set horarioid = '"+limp.getIdhorario()+"', usuarioid = '"+limp.getUsuarioid()+"', fecha_inicio = '"+limp.getFecha_inicio()+"', fecha_final = '"+limp.getFecha_final()+"', estado = '"+limp.getEstado()+"' where limpiezaid="+limp.getLimpiezaid();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
              System.err.println("Error"+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from limpieza where limpiezaid="+id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
             System.err.println("Error"+e);
        }
        return false;
    }
    
}
