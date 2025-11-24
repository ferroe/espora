package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * Estado que representa condiciones criticas para una poblacion.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class EstadoCritico implements EstadoPoblacion {

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
        System.out.println("Estado Critico: No hay reproducción.");
    }

    /**
     * En estado critico la mortalidad natural puede ser mayor.
     */
    @Override
    public void morirNatural() {
        int actual = poblacion.getTamanio();
        if (actual == 0) {
            return;
        }

        int mueren = (int)(actual * 0.05);

        if (mueren == 0 && actual > 0) {
            mueren = 1;
        }

        poblacion.setTamanio(actual - mueren);
    }
}