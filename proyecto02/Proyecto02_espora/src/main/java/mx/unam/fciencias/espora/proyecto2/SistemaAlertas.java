package mx.unam.fciencias.espora.proyecto2;

import java.util.List;

/**
 * Clase SistemaAlertas que implementa el Observer
 * notifica al usuario dependiendo de la situacion del ecosistema
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class SistemaAlertas implements Observer{

    private Ecosistema ecosistema;

    /**
     * Constructor del SistemaAlertas
     * @param ecosistema el ecosistema
     */
    public SistemaAlertas(Ecosistema ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }

    /**
     * Actualiza el estado del SistemaAlertas
     */
    @Override
    public void actualizar() {
        System.out.println("SistemaAlertas: NOTIFICADO - Buscando estados críticos...");
        
        ZonaEcosistema raiz = ecosistema.getXochimilcoRaiz();
        List<ComponenteEcosistema> zonas = raiz.getComponentes();
        
        for (ComponenteEcosistema zona : zonas) {
            if (zona instanceof ZonaEcosistema) {
                List<ComponenteEcosistema> poblaciones = ((ZonaEcosistema) zona).getComponentes();
                for (ComponenteEcosistema pob : poblaciones) {
                    if (pob.getEstado().equals("Crítico")) {                       
                        mostrarAlerta("¡" + pob.getNombre() + " ha entrado en estado crítico!");
                    }
                }
            }
        }
    }

    /**
     * Muestra una alerta con el mensaje proporcionado
     * @param mensaje el mensaje de la alerta
     */
    private void mostrarAlerta(String mensaje) {
        System.out.println("ALERTA: " + mensaje);
    }
}

   
