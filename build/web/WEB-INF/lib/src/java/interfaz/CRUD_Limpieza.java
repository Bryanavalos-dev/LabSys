
package interfaz;

import java.util.List;
import modelo.Limpieza;
public interface CRUD_Limpieza {
    
    public List listar();
    public Limpieza list(int limpiezaid);
    public boolean add(Limpieza limp);
    public boolean edit(Limpieza limp);
    public boolean eliminar(int limpiezaid);
        
    
}
