package mx.unam.fciencias.espora.proyecto2.vista;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import mx.unam.fciencias.espora.proyecto2.modelo.ComponenteEcosistema;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;

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
    private Set<String> especiesConAlertaActiva;

    /**
     * Construye el sistema de alertas y lo registra como observador del ecosistema.
     * @param ecosistema Ecosistema a observar.
     */
    public SistemaAlertas(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.especiesConAlertaActiva = new HashSet<>();
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
                    String idUnico = zona.getNombre() + "-" + pob.getNombre();

                    if ("Critico".equalsIgnoreCase(pob.getEstado())) {
                        
                        if (!especiesConAlertaActiva.contains(idUnico)) {
                            mostrarAlerta("¡URGENTE! " + pob.getNombre() + " en " + zona.getNombre() + " esta en estado CRÍTICO.");
                            // Lo agregamos a la memoria para no volver a gritar
                            especiesConAlertaActiva.add(idUnico);
                        }
                        
                    } else {
                        especiesConAlertaActiva.remove(idUnico);
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
            alerta.setHeaderText("Especie en Peligro");
            alerta.setContentText(mensaje);
            alerta.show(); 
        });
    }
}