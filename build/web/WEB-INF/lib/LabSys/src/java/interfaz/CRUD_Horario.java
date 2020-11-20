package interfaz;

import modelo.Horario;
import java.util.List;

public interface CRUD_Horario {
    public List listar();
    public Horario list(int id);
    public boolean add(Horario per);
    public boolean edit(Horario per);
    public boolean eliminar(int id);
    
}
