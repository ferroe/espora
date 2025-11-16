package mx.unam.fciencias.espora.proyecto2;

/**
 * Clase que representa el panel de una especie
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PanelEspecie implements Observer{

    private Ecosistema ecosistema;

    /**
     * Constructor del panel de especie
     * @param ecosistema el ecosistema
     */
    public PanelEspecie (Ecosistema ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
    }
    
    /**
     * Actualiza el estado del panel de especie
     */
    @Override
    public void actualizar() {
        ZonaEcosistema raiz = ecosistema.getXochimilcoRaiz();
        int tamanioTotal = raiz.getTamanio();
        double saludPromedio = raiz.getSalud();

        System.out.println("Actualización del Panel de Especie:");
        dibujar();
    }

    /**
     * Dibuja el panel de especie
     */
    private void dibujar() { 
    }
}
