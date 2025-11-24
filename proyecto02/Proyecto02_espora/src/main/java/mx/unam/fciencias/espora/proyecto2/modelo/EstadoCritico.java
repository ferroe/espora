package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * Estado que representa condiciones criticas para una poblacion.
 *
 */
public class EstadoCritico implements EstadoPoblacion{

    private PoblacionEspecie poblacion;

    /**
     * Construye el estado critico asociado a una poblacion.
     * @param poblacion Poblacion a la que pertenece.
     */
    public EstadoCritico(PoblacionEspecie poblacion) {
        this.poblacion = poblacion;
    }
    
    /**
     * En estado critico la poblacion tiene reproduccion reducida.
     */
    @Override
    public void reproducir() {
        int actual = poblacion.getTamanio();
        int nuevos = (int)(actual * 0.20);
        System.out.println("Estado Critico: Nacen " + nuevos + " nuevas especies");
        poblacion.setTamanio(actual + nuevos);
    }

    /**
     * En estado critico la mortalidad natural puede ser mayor.
     */
    @Override
    public void morirNatural() {
        int actual = poblacion.getTamanio();
        int mueren = (int)(actual * 0.05);
        System.out.println("Estado Critico: Mueren " + mueren + " especies por causas naturales");
        poblacion.setTamanio(actual - mueren);
    }
}