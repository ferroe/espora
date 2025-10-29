package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase TipoCuenta.
 * 
 * Enum que contiene a los tipos de cuenta 
 * que están disponibles en nuestro sistema.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public enum TipoCuenta {

    AHORRO("Ahorro"),
    NOMINA("Nómina"),
    INVERSION("Inversion");

    private final String nombre;

    /**
     * Constructor de la clase TipoCuenta.
     * @param nombre El nombre del tipo de cuenta.
     */
    TipoCuenta(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del tipo de cuenta.
     * @return El nombre del tipo de cuenta.
     */
    public String getNombre() {
        return nombre;
    }
}