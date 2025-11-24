package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * Interfaz que define el comportamiento de los distintos estados de una poblacion.
 *
 */
public interface EstadoPoblacion {

    /**
     * Ejecuta la logica de reproduccion propia del estado.
     */
    void reproducir();

    /**
     * Ejecuta la logica de mortalidad natural propia del estado.
     */
    void morirNatural();
    
}
