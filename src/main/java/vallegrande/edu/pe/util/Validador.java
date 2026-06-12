package vallegrande.edu.pe.util;

public class Validador {

    public static boolean requerido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /** Solo letras y espacios */
    public static boolean soloLetras(String texto) {
        return texto != null &&
                texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    /** Fecha formato yyyy-MM-dd */
    public static boolean esFechaValida(String fecha) {
        return fecha != null &&
                fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}