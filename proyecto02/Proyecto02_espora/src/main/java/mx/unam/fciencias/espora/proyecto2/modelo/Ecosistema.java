package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.ArrayList;
import java.util.List;
import mx.unam.fciencias.espora.proyecto2.vista.Observer;

/**
 * La clase Ecosistema que representa el ecosistema 
 * dentro de Xochimilco
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class Ecosistema implements Sujeto {
    
    private List<Observer> observadores;
    private ZonaEcosistema xochimilcoRaiz;
    private ModeloParametros modeloParametros;
    
    /**
     * Constructor de Ecosistema
     */
    public Ecosistema() {
        this.observadores = new ArrayList<>();
        this.xochimilcoRaiz = new ZonaEcosistema("Xochimilco");
        this.modeloParametros = new ModeloParametros();
    }

    /**
     * Simula el paso del tiempo en el ecosistema
     */
    public void simularPasoDelTiempo() {
        this.xochimilcoRaiz.actualizar(this.modeloParametros);
        this.notificarObservadores();
    }

    /**
     * Obtiene la zona raiz del ecosistema
     * @return La zona raiz del ecosistema
     */
    public ZonaEcosistema getXochimilcoRaiz() {
        return this.xochimilcoRaiz;
    }

    /**
     * Obtiene el modelo de parametros del ecosistema
     * @return El modelo de parametros del ecosistema
     */
    public ModeloParametros getModeloParametros() {
        return this.modeloParametros;
    }

    /**
     * Registra un observador en el ecosistema
     * @param o El observador a registrar
     */
    @Override
    public void registrarObservador(Observer o) {
        this.observadores.add(o);
    }

    /**
     * Elimina un observador del ecosistema
     * @param o El observador a eliminar
     */
    @Override
    public void removerObservador(Observer o) {
        this.observadores.remove(o);
    }

    /**
     *  Notifica a los observadores del ecosistema
     */
    @Override
    public void notificarObservadores() {
        for (Observer obs: this.observadores) {
            obs.actualizar();
        }
    } 
}