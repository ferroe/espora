package mx.unam.fciencias.espora.practica3;

/**
 * Clase que representa a un Prospecto
 * 
 * Se tiene el nombre, edad, clan y nivel de habilidad.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Prospecto {

    private String nombre;
    private int edad;
    private String clanProcedencia;
    private int nivelHabilidad;

    /**
     * Método constructor para el Prospecto.
     * @param nombre El nombre del ninja prospecto.
     * @param edad La edad del prospecto.
     * @param clanProcedencia El clan del que proviene.
     * @param nivelHabilidad El nivel de habilidad (1-3)
     */
    public Prospecto(String nombre, int edad, String clanProcedencia, 
                                     int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clanProcedencia = clanProcedencia;
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * Método get del Nombre
     * @return El nombre del prospecto.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método get del ClanProcedencia
     * @return El clan de procedencia del prospecto.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Método get del ClanProcedencia
     * @return El clan de procedencia del prospecto.
     */
    public String getClanProcedencia() {
        return this.clanProcedencia;
    }

    /**
     * Método get del NivelHabilidad.
     * @return El nivel de habilidad.
     */
    public int getNivelHabilidad() {
        return this.nivelHabilidad;
    }

    /**
     * Metodo toString para imprimir al Prospecto.
     * @return Una cadena con el nombre y clan del prospecto.
     */
    @Override
    public String toString() {
        return "Prospecto: " + this.nombre + " (Clan: " + this.clanProcedencia + ")";
    }   
}
