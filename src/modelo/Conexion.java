
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private final String base = "BD__HOTEL_ESTACIONAMIENTO";
    private final String user = "root";
    private final String password = "12345";
    static Statement instruccion=null;
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
             System.out.println("Se ha establecido la conexión correctamente a la base de datos"+url);
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }
     

}
