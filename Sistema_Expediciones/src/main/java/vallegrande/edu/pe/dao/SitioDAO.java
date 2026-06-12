package vallegrande.edu.pe.dao;

import vallegrande.edu.pe.model.SitioArqueologico;

import java.util.ArrayList;
import java.util.List;

public class SitioDAO {

    public boolean guardar(SitioArqueologico sitio) {

        System.out.println("Guardando: " + sitio.getNombre());

        return true;
    }

    public List<SitioArqueologico> listar() {

        return new ArrayList<>();
    }

    public boolean modificar(SitioArqueologico sitio) {

        System.out.println("Modificando: " + sitio.getNombre());

        return true;
    }

    public boolean eliminar(int codigo) {

        System.out.println("Eliminando código: " + codigo);

        return true;
    }
}
