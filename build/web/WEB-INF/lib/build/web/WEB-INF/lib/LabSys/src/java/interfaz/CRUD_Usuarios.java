package interfaz;

import modelo.Usuarios;
import java.util.List;

public interface CRUD_Usuarios {
    public List listar();
    public Usuarios list(int id);
    public boolean add(Usuarios per);
    public boolean edit(Usuarios per);
    public boolean eliminar(int id);
    
}
