package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ecosistema implements EcosistemaInterfaz { 
    
    private List<Observer> observadores;
    private ZonaEcosistema xochimilcoRaiz;
    // Eliminamos: private ModeloParametros modeloParametros; (Ya no es global)
    
    private int tickActual;

    public Ecosistema() {
        this.observadores = new ArrayList<>();
        this.xochimilcoRaiz = new ZonaEcosistema("Xochimilco");
        this.tickActual = 0;
    }

    // ... (Implementación de Sujeto: registrar, remover, notificar igual) ...
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
        // Como ya no hay global, podemos retornar null o 
        // mejor, retornar los de la primera zona para evitar errores en vistas antiguas
        // Pero lo ideal es que la Vista pida los parámetros DE LA ZONA.
        return null; 
    }

    @Override
    public void simularPasoDelTiempo() {
        tickActual++;
        int mes = (tickActual / 30) % 12;

        // Actualizamos el mes en CADA ZONA
        for (ComponenteEcosistema comp : xochimilcoRaiz.getComponentes()) {
            if (comp instanceof ZonaEcosistema) {
                ZonaEcosistema zona = (ZonaEcosistema) comp;
                zona.getParametros().setMesActual(mes);
            }
        }

        // Actualizamos el árbol (pasamos null porque cada zona usará el suyo)
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

    // --- ACCIONES LOCALES ---

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