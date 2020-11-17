package interfaz;

import modelo.Roles;
import java.util.List;

public interface CRUD_Roles {
    public List listar();
    public Roles list(int id);
    public boolean add(Roles per);
    public boolean edit(Roles per);
    public boolean eliminar(int id);
    
}
