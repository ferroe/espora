package mx.unam.fciencias.espora.proyecto2;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase es la poblacion de las especies
 * de un ecosistema.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PoblacionEspecie {

    private String nombre;
    private double saludPromedio;
    private int tamanio;
    private EstadoPoblacion estadoActual;
    private EstadoSaludable estadoSaludable;
    private EstadoRiesgo estadoRiesgo;
    private EstadoCritico estadoCritico;
    private EfectoEstrategia estrategia;
    private final int LIMITE_RIESGO = 100;
    private final int LIMITE_CRITICO = 30;

    /**
     * Constructor de la clase PoblacionEspecie
     * @param nombre El nombre de la especie
     * @param tamanioInicial El tamaño inicial de la población
     * @param saludInicial La salud inicial promedio de la población
     */
    public PoblacionEspecie (String nombre, int tamanioInicial, double saludInicial) {
        this.nombre = nombre;
        this.tamanio = tamanioInicial;
        this.saludPromedio = saludInicial;
        this.estadoSaludable = new EstadoSaludable(this);
        this.estadoRiesgo = new EstadoRiesgo(this);
        this.estadoCritico = new EstadoCritico(this);
        this.evaluarCambioEstado();
    }

    /**
     * Obtiene el nombre de la especie
     * @return El nombre de la especieq
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la salud promedio de la poblacion
     * @return La salud promedio de la poblacion
     */
    public double getSalud() {
        return this.saludPromedio;
    }

    /**
     * Actualiza la poblacion tomando en cuenta los parametros ambientales
     * @param parametros Los parametros ambientales que afectan a la poblacion
     */
    @Override
    public void actualizar (ParametroAmbiental parametros) {
        
        Map<String, Double> mapaDeParametros = new HashMap<>();
        mapaDeParametros.put("contaminacion", parametros.getNivelContaminacion());
        mapaDeParametros.put("especiesInvasoras", parametros.getNivelEspecies());
        mapaDeParametros.put("calidadAgua", parametros.getCalidadAgua());
        mapaDeParametros.put("nivelAgua", parametros.getNivelAgua());

        if (this.estrategia != null) {
            this.estrategia.calcularEfecto(this, mapaDeParametros);
        }

        this.reproducir();
        this.morirNatural();
    }

    /**
     * Hace que la poblacion se reproduzca
     */
    public void reproducir() {
        this.estadoActual.reproducir();
    }

    /**
     * Hace que la poblacion muera de forma natural
     */
    public void morirNatural() {
        this.estadoActual.morirNatural();
    }

    /**
     * Hace que la poblacion sea depredada
     * @param cantidad La cantidad de individuos depredados
     */
    public void serDepredado (int cantidad) {
        System.out.println(this.nombre + " ha sido depredado con" + cantidad + " individuos.");
        this.setTamanio(this.tamanio - cantidad);
    }

    /**
     * Actualiza el estado actual de la poblacion
     * @param nuevoEstado El nuevo estado de la poblacion
     */
    public void actualizarEstado(EstadoPoblacion nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    /**
     * Obtiene el estado saludable de la poblacion
     * @return El estado saludable de la poblacion
     */
    public EstadoPoblacion getEstadoSaludable() {
        return this.estadoSaludable;
    }

    /**
     * Obtiene el estado de riesgo de la poblacion
     * @return El estado de riesgo de la poblacion
     */
    public EstadoPoblacion getEstadoRiesgo() {
        return this.estadoRiesgo;
    }

    /**
     * Obtiene el estado crítico de la poblacion
     * @return El estado crítico de la poblacion
     */
    public EstadoPoblacion getEstadoCritico() {
        return this.estadoCritico;
    }

    /**
     * Actualiza el tamaño de la población
     * @param nuevoTamanio El nuevo tamaño de la población
     */
    public void setTamanio(int nuevoTamanio) {
        this.tamanio = (nuevoTamanio < 0) ? 0: nuevoTamanio;
        this.evaluarCambioEstado();
    }

    /**
     * Obtiene el tamaño de la población
     * @return El tamaño de la población
     */
    @Override
    public int getTamanio() {
        return this.tamanio;
    }

    /**
     * Actualiza la salud promedio de la población
     * @param nuevaSalud La nueva salud promedio de la población
     */
    public void setSaludPromedio(double nuevaSalud) {
        this.saludPromedio = nuevaSalud;
    }

    /**
     * Evalua si la poblacion debe cambiar de estado
     */
    private void evaluarCambioDeEstado() {
        if (this.tamanio > LIMITE_RIESGO) {
            if (this.estadoActual != this.estadoSaludable) {
                 this.actualizarEstado(this.estadoSaludable);
            }
        } else if (this.tamanio > LIMITE_CRITICO) {
             if (this.estadoActual != this.estadoRiesgo) {
                 this.actualizarEstado(this.estadoRiesgo);
            }
        } else {
             if (this.estadoActual != this.estadoCritico) {
                this.actualizarEstado(this.estadoCritico);
            }
        }
    }

    /**
     * Obtiene el estado actual de la poblacion
     * @return El estado actual de la poblacion
     */
    @Override
    public String getEstado() {
        if (estadoActual instanceof EstadoSaludable) return "Saludable";
        if (estadoActual instanceof EstadoRiesgo) return "En Riesgo"; 
        if (estadoActual instanceof EstadoCritico) return "Crítico";
        return "Desconocido";
    }

    /**
     * Pausa la poblacion
     */
    @Override
    public void pausa() {
    }

    /**
     * Reanuda la poblacion
     */
    @Override
    public void reanudar() {
    }
    
    /**
     * Establece la estrategia de efecto para la poblacion
     * @param estrategia La estrategia de efecto a establecer
     */
    public void setEstrategia(EfectoEstrategia estrategia) {
        this.estrategia = estrategia;
    }
    
}