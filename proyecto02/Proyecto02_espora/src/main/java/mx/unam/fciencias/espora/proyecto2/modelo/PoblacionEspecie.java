package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa la poblacion de una especie dentro de una zona del ecosistema.
 * Maneja su estado, tamanio y reproduccion segun una estrategia biologica.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class PoblacionEspecie implements ComponenteEcosistema{

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
     * Construye una poblacion con valores iniciales.
     * @param nombre Nombre de la especie.
     * @param tamanioInicial Tamaño inicial de la poblacion.
     * @param saludInicial Salud promedio inicial.
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
     * Obtiene el nombre de la especie.
     * @return Nombre de la especie.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la salud promedio de la poblacion.
     * @return Salud promedio.
     */
    public double getSalud() {
        return this.saludPromedio;
    }

    /**
     * Actualiza la poblacion segun los parametros ambientales.
     * @param parametros Parametros ambientales de la zona.
     */
    @Override
    public void actualizar (ModeloParametros parametros) {
        Map<String, Double> mapaDeParametros = new HashMap<>();
        mapaDeParametros.put("contaminacion", parametros.getNivelContaminacion());
        mapaDeParametros.put("especiesInvasoras", parametros.getNivelEspeciesInvasoras());
        mapaDeParametros.put("calidadAgua", parametros.getCalidadAgua());
        mapaDeParametros.put("nivelAgua", parametros.getNivelAgua());

        if (this.estrategia != null) {
            this.estrategia.calcularEfecto(this, mapaDeParametros);
        }

        if (this.saludPromedio < 0.4) {
            if (!(this.estadoActual instanceof EstadoCritico)) {
                actualizarEstado(this.estadoCritico);
            }
        } else {
            this.evaluarCambioEstado();
        }
        
        this.reproducir();
        this.morirNatural();
    }

    /**
     * Ejecuta la reproduccion segun el estado actual.
     */
    public void reproducir() {
        this.estadoActual.reproducir();
    }

    /**
     * Ejecuta la mortalidad natural segun el estado actual.
     */
    public void morirNatural() {
        this.estadoActual.morirNatural();
    }

    /**
     * Aplica depredacion reduciendo el tamanio.
     * @param cantidad Numero de individuos depredados.
     */
    public void serDepredado (int cantidad) {
        System.out.println(this.nombre + " ha sido depredado con" + cantidad + " individuos.");
        this.setTamanio(this.tamanio - cantidad);
    }

    /**
     * Establece el estado actual de la poblacion.
     * @param nuevoEstado Nuevo estado a asignar.
     */
    public void actualizarEstado(EstadoPoblacion nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    /**
     * Obtiene el estado saludable de la poblacion.
     * @return Instancia de EstadoSaludable.
     */
    public EstadoPoblacion getEstadoSaludable() {
        return this.estadoSaludable;
    }

    /**
     * Obtiene el estado de riesgo de la poblacion.
     * @return Instancia de EstadoRiesgo.
     */
    public EstadoPoblacion getEstadoRiesgo() {
        return this.estadoRiesgo;
    }

    /**
     * Obtiene el estado critico de la poblacion.
     * @return Instancia de EstadoCritico.
     */
    public EstadoPoblacion getEstadoCritico() {
        return this.estadoCritico;
    }

    /**
     * Establece el tamanio de la poblacion.
     * @param nuevoTamanio Nuevo tamanio de la poblacion.
     */
    public void setTamanio(int nuevoTamanio) {
        if (nuevoTamanio < 0) {
            this.tamanio = 0;
        } else {
            this.tamanio = nuevoTamanio;
        }
        this.evaluarCambioEstado();
    }

    /**
     * Obtiene el tamanio de la poblacion.
     * @return Tamaño actual.
     */
    @Override
    public int getTamanio() {
        return this.tamanio;
    }

    /**
     * Actualiza la salud promedio de la poblacion.
     * @param nuevaSalud Nueva salud promedio.
     */
    public void setSaludPromedio(double nuevaSalud) {
        this.saludPromedio = Math.max(0.0, Math.min(1.0, nuevaSalud));
    }

    /**
     * Evalua y actualiza el estado segun los limites definidos.
     */
    private void evaluarCambioEstado() {
        if (this.saludPromedio < 0.4) {
            return;
        }
        if (this.tamanio > LIMITE_RIESGO) {
            if (!(this.estadoActual instanceof EstadoSaludable)) {
                 this.actualizarEstado(this.estadoSaludable);
            }
        } else if (this.tamanio > LIMITE_CRITICO) {
             if (!(this.estadoActual instanceof EstadoRiesgo)) {
                 this.actualizarEstado(this.estadoRiesgo);
            }
        } else {
             if (!(this.estadoActual instanceof EstadoCritico)) {
                this.actualizarEstado(this.estadoCritico);
            }
        }
    }

    /**
     * Devuelve una descripcion del estado actual de la poblacion.
     * @return Cadena con el estado.
     */
    public String getEstado() {
        if (estadoActual instanceof EstadoSaludable) { 
            return "Saludable";
        }
        if (estadoActual instanceof EstadoRiesgo) {
            return "En Riesgo";
        }
        if (estadoActual instanceof EstadoCritico) {
            return "Critico";
        }
        return "Desconocido";
    }

    /**
     * Pausa la poblacion (no implementado en este modelo simple).
     */
    @Override
    public void pausa() {
    }

    /**
     * Reanuda la poblacion (no implementado en este modelo simple).
     */
    @Override
    public void reanudar() {
    }
    
    /**
     * Establece la estrategia de efecto para la poblacion.
     * @param estrategia Estrategia de efecto a establecer.
     */
    public void setEstrategia(EfectoEstrategia estrategia) {
        this.estrategia = estrategia;
    }
    
}