package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implementacion del modelo central del ecosistema de Xochimilco.
 * Mantiene la coleccion de zonas, administra el ciclo de simulacion
 * y notifica a los observadores registrados.
 *
 */
public class Ecosistema implements EcosistemaInterfaz { 
    
    private List<Observer> observadores;
    private ZonaEcosistema xochimilcoRaiz;
    private int tickActual;

    /**
     * Construye un ecosistema con la zona raiz "Xochimilco".
     */
    public Ecosistema() {
        this.observadores = new ArrayList<>();
        this.xochimilcoRaiz = new ZonaEcosistema("Xochimilco");
        this.tickActual = 0;
    }

    @Override
    public void registrarObservador(Observer o) { 
        observadores.add(o); 
    }

    @Override
    public void removerObservador(Observer o) { 
        observadores.remove(o); 
    }

    @Override
    public void notificarObservadores() {
        for (Observer obs : observadores) { 
            obs.actualizar(); 
        }
    }

    @Override
    public ZonaEcosistema getXochimilcoRaiz() {
        return this.xochimilcoRaiz;
    }

    @Override
    public ModeloParametros getModeloParametros() {
        return null; 
    }

    /**
     * Realiza un tick de la simulacion: actualiza el mes en cada zona,
     * ejecuta las actualizaciones del arbol de zonas y notifica observadores.
     */
    @Override
    public void simularPasoDelTiempo() {
        tickActual++;
        int mes = (tickActual / 30) % 12;

        for (ComponenteEcosistema comp : xochimilcoRaiz.getComponentes()) {
            if (comp instanceof ZonaEcosistema) {
                ZonaEcosistema zona = (ZonaEcosistema) comp;
                zona.getParametros().setMesActual(mes);
            }
        }

        this.xochimilcoRaiz.actualizar(null);
        
        notificarObservadores();
    }

    @Override
    public ZonaEcosistema buscarZona(String nombre) {
        for (ComponenteEcosistema comp : xochimilcoRaiz.getComponentes()) {
            if (comp.getNombre().equals(nombre) && comp instanceof ZonaEcosistema) {
                return (ZonaEcosistema) comp;
            }
        }
        return null;
    }

    @Override
    public void tirarBasura(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            System.out.println("Modelo: Tirando basura en " + nombreZona);
            zona.getParametros().aplicarContaminacion(0.10);
            notificarObservadores();
        }
    }

    @Override
    public void limpiarZona(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            System.out.println("Modelo: Limpiando " + nombreZona);
            zona.getParametros().aplicarLimpieza(0.15);
            notificarObservadores();
        }
    }

    @Override
    public void introducirInvasoras(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            double actual = zona.getParametros().getNivelEspeciesInvasoras();
            zona.getParametros().setNivelEspeciesInvasoras(actual + 0.10);
            notificarObservadores();
        }
    }

    @Override
    public void restaurarFlora(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            zona.getParametros().aplicarLimpieza(0.05);
            double actual = zona.getParametros().getNivelEspeciesInvasoras();
            double nuevo = actual - 0.05;
            if (nuevo < 0) nuevo = 0;
            zona.getParametros().setNivelEspeciesInvasoras(nuevo);
            notificarObservadores();
        }
    }

    @Override
    public void repoblarEspecie(String nombreZona, String nombreEspecieParcial) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            for (ComponenteEcosistema comp : zona.getComponentes()) {
                if (comp instanceof PoblacionEspecie) {
                    PoblacionEspecie pob = (PoblacionEspecie) comp;
                    if (pob.getNombre().contains(nombreEspecieParcial)) {
                        pob.setTamanio(pob.getTamanio() + 20);
                    }
                }
            }
            notificarObservadores();
        }
    }
}