package mx.unam.fciencias.espora.proyecto2.vista;

import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz; // Interfaz
import mx.unam.fciencias.espora.proyecto2.modelo.ModeloParametros;
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;

public class PanelParametros implements Observer {

    private EcosistemaInterfaz ecosistema; // Solo lectura/interfaz

    public PanelParametros(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        // Nos registramos como observadores a través de la interfaz
        this.ecosistema.registrarObservador(this);
    }

    @Override
    public void actualizar() {
        // Leemos los datos nuevos de manera segura
        ModeloParametros parametros = ecosistema.getModeloParametros();
        
        // Aquí iría tu lógica para actualizar los sliders o etiquetas de la UI
        // System.out.println("PanelParametros actualizado: Contaminación = " + parametros.getNivelContaminacion());
    }
}