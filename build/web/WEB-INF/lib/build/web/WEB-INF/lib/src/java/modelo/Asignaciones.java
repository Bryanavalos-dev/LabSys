/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gerson
 */
public class Asignaciones {
        private long asignacionid;
        private long laboratorioid;
        private long usuarioid;
        private String laboratorio;
        private String usuario;

    public long getAsignacionid() {
        return asignacionid;
    }

    public void setAsignacionid(long asignacionid) {
        this.asignacionid = asignacionid;
    }

    public long getLaboratorioid() {
        return laboratorioid;
    }

    public void setLaboratorioid(long laboratorioid) {
        this.laboratorioid = laboratorioid;
    }

    public long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
