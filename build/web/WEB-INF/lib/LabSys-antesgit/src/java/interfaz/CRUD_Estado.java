package interfaz;

import modelo.Estado;
import java.util.List;

public interface CRUD_Estado {
    public List listar();
    public Estado list(int id);
    public boolean add(Estado per);
    public boolean edit(Estado per);
    public boolean eliminar(int id);
    
}
