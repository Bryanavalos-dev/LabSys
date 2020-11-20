package parcial3progra3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Statement;


public class ConexionSql {
    Connection conexion = null;
    static ConexionSql instancia = null;
    
    public ConexionSql() throws Exception{
        //Se carga el controlador o proveedor de datos (DRIVERS)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String strConex = "jdbc:sqlserver://GERSON-D\\SQLEXPRESS:1433;databaseName=p3;user=sa;password=1234;";
        conexion=DriverManager.getConnection(strConex);
        
        
    }
    
    public static ConexionSql getInstancia() throws Exception{
        if (instancia==null) instancia=new ConexionSql();
        return instancia;
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
