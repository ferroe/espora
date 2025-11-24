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

    /**
     * Registra un observador para recibir notificaciones del modelo.
     * @param o Observador a registrar.
     */
    @Override
    public void registrarObservador(Observer o) { 
        observadores.add(o); 
    }

    /**
     * Remueve un observador previamente registrado.
     * @param o Observador a remover.
     */
    @Override
    public void removerObservador(Observer o) { 
        observadores.remove(o); 
    }

    /**
     * Notifica a todos los observadores registrados.
     */
    @Override
    public void notificarObservadores() {
        for (Observer obs : observadores) { 
            obs.actualizar(); 
        }
    }

    /**
     * Devuelve la raiz del arbol de zonas de Xochimilco.
     */
    @Override
    public ZonaEcosistema getXochimilcoRaiz() {
        return this.xochimilcoRaiz;
    }

    /**
     * Obtiene los parametros del modelo usados en la simulacion.
     * @return Objeto con parametros del modelo.
     */
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

    /**
     * Busca y devuelve la zona con el nombre indicado.
     * @param nombre Nombre de la zona a buscar.
     * @return Zona encontrada o null si no existe.
     */
    @Override
    public ZonaEcosistema buscarZona(String nombre) {
        for (ComponenteEcosistema comp : xochimilcoRaiz.getComponentes()) {
            if (comp.getNombre().equals(nombre) && comp instanceof ZonaEcosistema) {
                return (ZonaEcosistema) comp;
            }
        }
        return null;
    }

    /**
     * Simula el tirar basura en la zona indicada.
     * @param nombreZona Nombre de la zona afectada.
     */
    @Override
    public void tirarBasura(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            System.out.println("Modelo: Tirando basura en " + nombreZona);
            zona.getParametros().aplicarContaminacion(0.10);
            notificarObservadores();
        }
    }

    /**
     * Limpia la zona especificada aplicando acciones de conservacion.
     * @param nombreZona Nombre de la zona a limpiar.
     */
    @Override
    public void limpiarZona(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            System.out.println("Modelo: Limpiando " + nombreZona);
            zona.getParametros().aplicarLimpieza(0.15);
            notificarObservadores();
        }
    }

    /**
     * Repuebla la especie indicada en la zona especificada.
     * @param nombreZona Zona donde repoblar.
     * @param nombreEspecie Nombre de la especie a repoblar.
     */
    @Override
    public void introducirInvasoras(String nombreZona) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            double actual = zona.getParametros().getNivelEspeciesInvasoras();
            zona.getParametros().setNivelEspeciesInvasoras(actual + 0.10);
            notificarObservadores();
        }
    }

    /**
     * Restaura la flora de la zona indicada.
     * @param nombreZona Nombre de la zona cuya flora se restaura.
     */
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

    /**
     * Repuebla la especie indicada en la zona especificada.
     * @param nombreZona Zona donde repoblar.
     * @param nombreEspecie Nombre de la especie a repoblar.
     */
    @Override
    public void repoblarEspecie(String nombreZona, String nombreEspecieParcial) {
        ZonaEcosistema zona = buscarZona(nombreZona);
        if (zona != null) {
            boolean existe = false;
            for (ComponenteEcosistema comp : zona.getComponentes()) {
                if (comp instanceof PoblacionEspecie) {
                    PoblacionEspecie pob = (PoblacionEspecie) comp;
                    if (pob.getNombre().contains(nombreEspecieParcial)) {
                        pob.setTamanio(pob.getTamanio() + 20);
                        pob.setSaludPromedio(1.0);
                        pob.actualizarEstado(pob.getEstadoSaludable());
                        existe = true;
                    }
                }
            }
            
            if (!existe && nombreEspecieParcial.equals("Ajolote")) {
                System.out.println("Reintroduciendo Ajolote en " + nombreZona);
                PoblacionEspecie nuevaPob = new PoblacionEspecie("Ajolote (Reintro.)", 20, 1.0);
                nuevaPob.setEstrategia(new EstrategiaAjolote());
                nuevaPob.actualizarEstado(nuevaPob.getEstadoSaludable());
                zona.agregarComponente(nuevaPob);
            }
            
            notificarObservadores();
        }
    }
}