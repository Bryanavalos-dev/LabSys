package modelo.entidad;
// Generated 10-20-2020 06:59:21 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoPago generated by hbm2java
 */
public class TipoPago  implements java.io.Serializable {


     private int idtipoPago;
     private String nombre;
     private Set<Alquiler> alquilers = new HashSet<Alquiler>(0);

    public TipoPago() {
    }

	
    public TipoPago(int idtipoPago) {
        this.idtipoPago = idtipoPago;
    }
    public TipoPago(int idtipoPago, String nombre, Set<Alquiler> alquilers) {
       this.idtipoPago = idtipoPago;
       this.nombre = nombre;
       this.alquilers = alquilers;
    }
   
    public int getIdtipoPago() {
        return this.idtipoPago;
    }
    
    public void setIdtipoPago(int idtipoPago) {
        this.idtipoPago = idtipoPago;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Alquiler> getAlquilers() {
        return this.alquilers;
    }
    
    public void setAlquilers(Set<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }




}


