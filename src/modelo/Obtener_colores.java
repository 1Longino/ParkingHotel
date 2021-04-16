package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Obtener_colores {

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

    public Vector<Obtener_colores> mostrarEstados() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Obtener_colores> datos = new Vector<Obtener_colores>();
        Obtener_colores dat = null;
        try {

            String sql = "SELECT * FROM colores";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Obtener_colores();
            dat.setId(0);
            dat.setNombre("Elige Color");
            datos.add(dat);

            while (rs.next()) {
                dat = new Obtener_colores();
                dat.setId(rs.getInt("id_color"));
                dat.setNombre(rs.getString("descripcion"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
