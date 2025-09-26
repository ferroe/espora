package mx.unam.fciencias.espora.practica3;

/**
 * Clase que representa a un Voluntario
 * 
 * Se tiene el nombre, edad, clan, rango y nivel de habilidad.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class Voluntario {

    private String nombre;
    private int edad;
    private String clanProcedencia;
    private String rango;
    private int nivelHabilidad;

    /**
     * Método constructor para el Voluntario.
     * @param nombre El nombre del ninja voluntario.
     * @param edad La edad del voluntario.
     * @param clanProcedencia El clan del que proviene.
     * @param rango El rango que tiene (genin, chunin, jonin)
     * @param nivelHabilidad El nivel de habilidad (4-6)
     */
    public Voluntario(String nombre, int edad, String clanProcedencia, 
                                    String rango, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clanProcedencia = clanProcedencia;
        this.rango = rango;
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * Método get del Nombre
     * @return El nombre del voluntario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método get del ClanProcedencia
     * @return El clan de procedencia del voluntario.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Método get del ClanProcedencia
     * @return El clan de procedencia del voluntario.
     */
    public String getClanProcedencia() {
        return this.clanProcedencia;
    }

    /**
     * Método get del Rango.
     * @return El rango en un string.
     */
    public String getRango() {
        return this.rango;
    }

    /**
     * Método get del NivelHabilidad.
     * @return El nivel de habilidad.
     */
    public int getNivelHabilidad() {
        return this.nivelHabilidad;
    }

    /**
     * Metodo toString para imprimir al Voluntario.
     * @return Una cadena con el nombre, rango y clan del voluntario.
     */
    @Override
    public String toString() {
        return "Líder: " + this.nombre + " (Rango: " + this.rango + ", Clan: " + this.clanProcedencia + ")";
    }   
}
