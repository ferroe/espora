package mx.unam.fciencias.espora.proyecto2.vista;

import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ModeloParametros;
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;

/**
 *
 * Panel que puede mostrar y controlar parametros globales/locales del ecosistema.
 * Se registra como observador del modelo.
 *
 */
public class PanelParametros implements Observer {

    private EcosistemaInterfaz ecosistema;

    public PanelParametros(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }

    @Override
    public void actualizar() {
        ModeloParametros parametros = ecosistema.getModeloParametros();    }
}