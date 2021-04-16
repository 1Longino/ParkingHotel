
package hotel_estacionamiento;
import java.sql.*;

public class Conexion_MYSQL 
{
    static String bd="BD_Hotel",login="mysql",password=""
            + "";
    static String url="jdbc:mysql://localhost:5432/"+bd;
    static boolean conectado;
    static Statement instruccion=null;
    static ResultSet resultados=null;
    static int filas=0;
    static String controlador="org.mysql.Driver";
    static Connection conn=null;
    int i;
    
    public Conexion_MYSQL()
    {
        try
        {
            Class.forName(controlador).newInstance();
            conn=DriverManager.getConnection(url,login,password);
            instruccion=conn.createStatement();
            if(conn!=null)
            {
                System.out.println("Conexión exitosa a base de datos"+url);
                conectado=true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            conectado=false;
        }
    }
    int obtener_Maximo(String sentencia)
    {
        i=0;
        try
        {
            resultados=consultar(sentencia);
            while(resultados.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
            return i;
    }
    public void altas(String sentencia)
    {
        try
        {
            instruccion.executeUpdate(sentencia);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static ResultSet consultar(String sentenciaSQL)
    {
        try
        {
            resultados=instruccion.executeQuery(sentenciaSQL);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return resultados;
    }
    void salir()
    {
        try
        {
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main (String args[])
    { 
        Conexion_MYSQL c=new Conexion_MYSQL();
    }
}
