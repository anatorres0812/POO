package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.dao.ExpedicionDAO;
import vallegrande.edu.pe.model.Usuario;
import vallegrande.edu.pe.util.Validador;

import java.util.List;

public class ExpedicionController {

    private final ExpedicionDAO dao = new ExpedicionDAO();

    public String guardar(String codigo,
                          String nombre,
                          String fecha,
                          String expedicion) {

        if (!Validador.requerido(codigo))
            return "El código es requerido.";

        if (!Validador.soloLetras(nombre))
            return "El nombre solo debe contener letras.";

        if (!Validador.esFechaValida(fecha))
            return "Fecha inválida.";

        if (!Validador.soloLetras(expedicion))
            return "La expedición solo debe contener letras.";

        Usuario u = new Usuario(
                Integer.parseInt(codigo),
                nombre,
                fecha,
                expedicion
        );

        return dao.insertar(u)
                ? "OK"
                : "Error al guardar.";
    }

    public String actualizar(int codigo,
                             String nombre,
                             String fecha,
                             String expedicion) {

        Usuario u = new Usuario(
                codigo,
                nombre,
                fecha,
                expedicion
        );

        return dao.actualizar(u)
                ? "OK"
                : "Error al actualizar.";
    }

    public boolean eliminar(int codigo) {
        return dao.eliminar(codigo);
    }

    public List<Usuario> listar() {
        return dao.listar();
    }

    public String guardar(String nombre, String fecha, String expedicion) {
        return nombre;
    }
}