package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * Estado que representa que la poblacion se encuentra en condiciones de riesgo.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class EstadoRiesgo implements EstadoPoblacion{

    private PoblacionEspecie poblacion;

    /**
     * Construye el estado de riesgo para la poblacion dada.
     * @param poblacion Poblacion asociada.
     */
    public EstadoRiesgo(PoblacionEspecie poblacion) {
        this.poblacion = poblacion;
    }
    
    /**
     * En estado de riesgo la reproduccion y mortalidad siguen reglas intermedias.
     */
    @Override
    public void reproducir() {
        int actual = poblacion.getTamanio();
        int nuevos = (int)(actual * 0.20);
        System.out.println("Estado Riesgo: Nacen " + nuevos + " nuevas especies");
        poblacion.setTamanio(actual + nuevos);
    }

    /**
     * Mortalidad natural en estado de riesgo.
     */
    @Override
    public void morirNatural() {
        int actual = poblacion.getTamanio();
        int mueren = (int)(actual * 0.05);
        System.out.println("Estado Riesgo: Mueren " + mueren + " especies por causas naturales");
        poblacion.setTamanio(actual - mueren);
    }
}