package mx.unam.fciencias.espora.proyecto2.vista;

import java.util.List;
import mx.unam.fciencias.espora.proyecto2.modelo.ComponenteEcosistema;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * Componente que revisa el estado del ecosistema y emite alertas por consola
 * cuando detecta poblaciones en estado critico.
 *
 * @author Equipo Espora
 * @version 1.0
 */

public class SistemaAlertas implements Observer {

    private EcosistemaInterfaz ecosistema;

    /**
     * Construye el sistema de alertas y lo registra como observador del ecosistema.
     * @param ecosistema Ecosistema a observar.
     */
    public SistemaAlertas(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }

    /** 
     * Revisa las poblaciones del ecosistema y muestra alertas por consola
     * si alguna ha entrado en estado critico.
     */
    @Override
    public void actualizar() {
        ZonaEcosistema raiz = ecosistema.getXochimilcoRaiz();
        List<ComponenteEcosistema> zonas = raiz.getComponentes();
        
        for (ComponenteEcosistema zona : zonas) {
            if (zona instanceof ZonaEcosistema) {
                List<ComponenteEcosistema> poblaciones = ((ZonaEcosistema) zona).getComponentes();
                for (ComponenteEcosistema pob : poblaciones) {
                    if ("Crítico".equals(pob.getEstado())) {                       
                        mostrarAlerta("¡" + pob.getNombre() + " ha entrado en estado crítico!");
                    }
                }
            }
        }
    }

    /**
     * Muestra una alerta por consola.
     * @param mensaje Mensaje de la alerta.
     */
    private void mostrarAlerta(String mensaje) {
        Platform.runLater(() -> {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Alerta Ambiental");
            alerta.setHeaderText("¡Atención!");
            alerta.setContentText(mensaje);
            alerta.show();
        });
    }
}