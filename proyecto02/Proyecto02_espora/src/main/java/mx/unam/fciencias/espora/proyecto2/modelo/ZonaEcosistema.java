package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * La interfaz ComponenteEcosistema 
 * de nuestro ecosistema Xochimilco
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ZonaEcosistema implements ComponenteEcosistema {

    private String nombre;
    private List<ComponenteEcosistema> componentes;

    /**
     * Constructor de ZonaEcosistema
     * @param nombre El nombre de la zona
     */
    public ZonaEcosistema(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    /**
     * Agrega un componente al ecosistema
     * @param componente El componente que se agrega
     */
    public void agregarComponente(ComponenteEcosistema componente) {
        componentes.add(componente);
    }

    /**
     * Remueve un componente del ecosistema
     * @param componente El componente que se remueve
     */
    public void removerComponente(ComponenteEcosistema componente) {
        componentes.remove(componente);
    }
    
    /**
     * Obtiene los componentes del ecosistema
     * @return La lista de componentes del ecosistema
     */
    public List<ComponenteEcosistema> getComponentes() {
        return this.componentes;
    }

    /**
     * El nombre del componente del ecosistema
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Actualiza el estado del componente del ecosistema
     * @param parametro El parametro ambiental
     */
    @Override
    public void actualizar(ModeloParametros parametros) {
        for (ComponenteEcosistema componente : componentes) {
            componente.actualizar(parametros);
        }
    }

    /**
     * La salud del ecosistema
     */
    @Override
    public double getSalud() {
        if (componentes.isEmpty()) {
            return 0.0;
        }

        double saludTotal = 0.0;
        for (ComponenteEcosistema componente : componentes) {
            saludTotal += componente.getSalud();
        }
        return saludTotal / componentes.size();
    }

    /**
     * El tamano del ecosistema
     */
    @Override
    public int getTamanio() {
        int tamanioTotal = 0;
        for (ComponenteEcosistema componente : componentes) {
            tamanioTotal += componente.getTamanio();
        }
        return tamanioTotal;
    }

    /**
     * El estado del ecosistema
     */
    @Override
    public String getEstado() {
        return "Zona";
    }

    /**
     * Pausa el ecosistema
     */
    @Override
    public void pausa() {
        for (ComponenteEcosistema componente : componentes) {
            componente.pausa();
        }
    } 

    /**
     * Reanuda el ecosistema
     */
    @Override
    public void reanudar() {    
        for (ComponenteEcosistema componente : componentes) {
            componente.reanudar();
        }
    }
}