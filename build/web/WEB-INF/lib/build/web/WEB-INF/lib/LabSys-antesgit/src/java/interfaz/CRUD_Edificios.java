package interfaz;

import modelo.Edificios;
import java.util.List;

public interface CRUD_Edificios {
    public List listar();
    public Edificios list(int id);
    public boolean add(Edificios per);
    public boolean edit(Edificios per);
    public boolean eliminar(int id);
    
}
