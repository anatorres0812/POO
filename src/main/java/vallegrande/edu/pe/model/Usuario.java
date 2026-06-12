package vallegrande.edu.pe.model;

public class Usuario {

    private int codigo;
    private String nombre;
    private String fecha;
    private String expedicion;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre,
                   String fecha, String expedicion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.expedicion = expedicion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getExpedicion() {
        return expedicion;
    }

    public void setExpedicion(String expedicion) {
        this.expedicion = expedicion;
    }
}