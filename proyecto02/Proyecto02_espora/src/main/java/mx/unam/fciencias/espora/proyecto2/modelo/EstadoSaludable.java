package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * Estado que representa condiciones favorables para la poblacion.
 *
 */
public class EstadoSaludable implements EstadoPoblacion{

    private PoblacionEspecie poblacion;

    /**
     * Construye el estado saludable asociado a una poblacion.
     * @param poblacion Poblacion a la que pertenece.
     */
    public EstadoSaludable(PoblacionEspecie poblacion) {
        this.poblacion = poblacion;
    }
    
    /**
     * Reproduccion en condiciones saludables.
     */
    @Override
    public void reproducir() {
        int actual = poblacion.getTamanio();
        int nuevos = (int)(actual * 0.20);
        System.out.println("Estado Saludable: Nacen " + nuevos + " nuevas especies");
        poblacion.setTamanio(actual + nuevos);
    }

    /**
     * Mortalidad natural en condiciones saludables.
     */
    @Override
    public void morirNatural() {
        int actual = poblacion.getTamanio();
        int mueren = (int)(actual * 0.05);
        System.out.println("Estado Saludable: Mueren " + mueren + " especies por causas naturales");
        poblacion.setTamanio(actual - mueren);
    }
}