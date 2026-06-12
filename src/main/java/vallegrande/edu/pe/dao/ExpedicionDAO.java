package vallegrande.edu.pe.dao;

import vallegrande.edu.pe.model.Usuario;
import vallegrande.edu.pe.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpedicionDAO {

    // CREATE
    public boolean insertar(Usuario u) {

        String sql = "INSERT INTO usuarios(codigo,nombre,fecha,expedicion) VALUES(?,?,?,?)";

        try (Connection c = Conexion.getConexion();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, u.getCodigo());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getFecha());
            ps.setString(4, u.getExpedicion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (Connection c = Conexion.getConexion();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Usuario u = new Usuario(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("fecha"),
                        rs.getString("expedicion")
                );

                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public boolean actualizar(Usuario u) {

        String sql = """
                UPDATE usuarios
                SET nombre=?, fecha=?, expedicion=?
                WHERE codigo=?
                """;

        try (Connection c = Conexion.getConexion();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getFecha());
            ps.setString(3, u.getExpedicion());
            ps.setInt(4, u.getCodigo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminar(int codigo) {

        String sql = "DELETE FROM usuarios WHERE codigo=?";

        try (Connection c = Conexion.getConexion();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}