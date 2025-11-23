package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ZonaEcosistema implements ComponenteEcosistema {

    private String nombre;
    private List<ComponenteEcosistema> componentes;
    private ModeloParametros parametrosLocales; 

    public ZonaEcosistema(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
        this.parametrosLocales = new ModeloParametros();
    }

    public ModeloParametros getParametros() {
        return this.parametrosLocales;
    }

    public void agregarComponente(ComponenteEcosistema componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponenteEcosistema componente) {
        componentes.remove(componente);
    }
    
    public List<ComponenteEcosistema> getComponentes() {
        return this.componentes;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void actualizar(ModeloParametros parametrosGlobalesIgnorados) {
        for (ComponenteEcosistema componente : componentes) {
            // Usamos los parámetros locales de esta zona
            componente.actualizar(this.parametrosLocales); 
        }
    }

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

    @Override
    public int getTamanio() {
        int tamanioTotal = 0;
        for (ComponenteEcosistema componente : componentes) {
            tamanioTotal += componente.getTamanio();
        }
        return tamanioTotal;
    }

    @Override
    public String getEstado() {
        if (componentes.isEmpty()) {
            return "Sin Vida";
        }
        
        boolean hayRiesgo = false;
        
        for (ComponenteEcosistema comp : componentes) {
            String estadoHijo = comp.getEstado();
            
            // Prioridad 1: Crítico
            if ("Crítico".equalsIgnoreCase(estadoHijo)) {
                return "Crítico";
            }
            
            // Prioridad 2: Detectar si hay riesgo
            if ("En Riesgo".equalsIgnoreCase(estadoHijo)) {
                hayRiesgo = true;
            }
        }
        
        // CORRECCIÓN: Usamos if-else en lugar de operador ternario (?)
        if (hayRiesgo) {
            return "En Riesgo";
        } else {
            return "Saludable";
        }
    }

    @Override
    public void pausa() {
        for (ComponenteEcosistema componente : componentes) {
            componente.pausa();
        }
    } 

    @Override
    public void reanudar() {    
        for (ComponenteEcosistema componente : componentes) {
            componente.reanudar();
        }
    }
}