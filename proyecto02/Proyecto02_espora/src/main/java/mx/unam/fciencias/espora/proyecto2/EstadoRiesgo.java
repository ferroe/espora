import mx.unam.fciencias.espora.proyecto2;

/**
 * Esta clase representa el estado de riesgo de una poblacion,
 * implementando los metodos de la interfaz EstadoPoblacion.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class EstadoRiesgo implements EstadoPoblacion{

    private PoblacionEspecie poblacion;

    /**
     * Constructor de la clase
     * @param poblacion la poblacion del estado
     */
    public EstadoRiesgo(PoblacionEspecie poblacion) {
        this.poblacion = poblacion;
    }
    
    /**
     * Metodos implementados de la interfaz EstadoPoblacion
     */
    @Override
    public void reproducir() {
        int actual = poblacion.getTamanio();
        int nuevos = (int)(actual * 0.20);
        System.out.println("Estado Riesgo: Nacen " + nuevos + " nuevas especies");
        poblacion.setTamanio(actual + nuevos);
    }

    /**
     * Metodo de morir de forma natural
     */
    @Override
    public void morirNatural() {
        int actual = poblacion.getTamanio();
        int mueren = (int)(actual * 0.05);
        System.out.println("Estado Riesgo: Mueren " + mueren + " especies por causas naturales");
        poblacion.setTamanio(actual - mueren);
    }
}