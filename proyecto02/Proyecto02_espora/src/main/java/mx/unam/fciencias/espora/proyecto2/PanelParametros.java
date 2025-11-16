package mx.unam.fciencias.espora.proyecto2;

import java.util.List;

/**
 * Clase PanelParametros que implementa el Observer
 * que actualiza los parametros del ecosistema 
 * @author Equipo Espora
 * @version 1.0
 */

public class PanelParametros implements Observer{

    private Ecosistema ecosistema;

    public PanelParametros(Ecosistema ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }

    @Override
    public void actualizar() {
        ModeloParametros parametros = ecosistema.getModeloParametros();
    }
}