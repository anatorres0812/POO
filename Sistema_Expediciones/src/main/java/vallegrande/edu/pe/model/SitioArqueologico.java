package vallegrande.edu.pe.model;

public class SitioArqueologico {

    private String codigo;
    private String nombre;
    private String pais;
    private int anioDescubrimiento;
    private String estadoConservacion;

    // Constructor vacío
    public SitioArqueologico() {
    }

    // Constructor con parámetros
    public SitioArqueologico(String codigo, String nombre, String pais,
                             int anioDescubrimiento, String estadoConservacion) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.anioDescubrimiento = anioDescubrimiento;
        this.estadoConservacion = estadoConservacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnioDescubrimiento() {
        return anioDescubrimiento;
    }

    public void setAnioDescubrimiento(int anioDescubrimiento) {
        this.anioDescubrimiento = anioDescubrimiento;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String toString() {
        return "SitioArqueologico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", anioDescubrimiento=" + anioDescubrimiento +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                '}';
    }
}