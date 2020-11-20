package interfaz;

import modelo.Laboratorios;
import java.util.List;

public interface CRUD_Laboratorios {
    public List listar();
    public Laboratorios list(int id);
    public boolean add(Laboratorios per);
    public boolean edit(Laboratorios per);
    public boolean eliminar(int id);
    
}
