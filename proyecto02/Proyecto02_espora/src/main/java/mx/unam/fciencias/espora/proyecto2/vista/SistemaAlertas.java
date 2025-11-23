package mx.unam.fciencias.espora.proyecto2.vista;

import java.util.List;
import mx.unam.fciencias.espora.proyecto2.modelo.ComponenteEcosistema;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz; // Interfaz
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;

public class SistemaAlertas implements Observer {

    private EcosistemaInterfaz ecosistema;

    public SistemaAlertas(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }

    @Override
    public void actualizar() {
        // Lógica segura usando la interfaz
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

    private void mostrarAlerta(String mensaje) {
        System.out.println("[ALERTA DE SISTEMA]: " + mensaje);
        // Aquí podrías mostrar un Dialog de JavaFX
    }
}