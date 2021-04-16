package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class No_habitaciones {

    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Vector<No_habitaciones> mostrarhabitacion() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<No_habitaciones> datos = new Vector<No_habitaciones>();
        No_habitaciones dat = null;
        try {

            String sql = "SELECT * FROM Habitaciones";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new No_habitaciones();
            dat.setId(0);
            dat.setNombre("Elige una opción");
            datos.add(dat);

            while (rs.next()) {
                dat = new No_habitaciones();
                dat.setId(rs.getInt("id_habitacion"));
                dat.setNombre(rs.getString("id_habitacion"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}