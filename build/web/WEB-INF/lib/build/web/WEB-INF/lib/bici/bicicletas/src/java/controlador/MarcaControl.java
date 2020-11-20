/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.MarcaDao;
import modelo.entidad.Marca;



/**
 *
 * @author Rolando
 */
//@Named(value = "marcaControl")
//@Dependent
@ManagedBean
@ViewScoped
public class MarcaControl implements Serializable{
    private List<Marca> listaMarcas;
    private Marca marca;
    /**
     * Creates a new instance of MarcaControl
     */
    public MarcaControl() {
    }

    public List<Marca> getListaMarcas() {
        MarcaDao ed = new MarcaDao();
        listaMarcas = ed.listarMarcas();
        return listaMarcas;
    }

    public void setListaMarcas(List<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public void limpiarMarca() {
        marca = new Marca();
    }

    public void agregarMarca() {
        MarcaDao ed = new MarcaDao();
        ed.agregar(marca);
    }

    public void modificarMarca() {
        MarcaDao ed = new MarcaDao();
        ed.modificar(marca);
        limpiarMarca();
    }

    public void eliminarMarca() {
        MarcaDao ed = new MarcaDao();
        ed.eliminar(marca);
        limpiarMarca();
    }

    
}
