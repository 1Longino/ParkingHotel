package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Obtener_marcas {

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

    public Vector<Obtener_marcas> mostrarEstados() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Obtener_marcas> datos = new Vector<Obtener_marcas>();
        Obtener_marcas dat = null;
        try {

            String sql = "SELECT * FROM marcas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Obtener_marcas();
            dat.setId(0);
            dat.setNombre("Elige la marca");
            datos.add(dat);

            while (rs.next()) {
                dat = new Obtener_marcas();
                dat.setId(rs.getInt("id_marca"));
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
