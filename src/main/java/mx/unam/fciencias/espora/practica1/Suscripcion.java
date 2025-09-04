package mx.unam.fciencias.espora.practica1;

/**
 * Clase para Suscripcion
 * En esta clase se representa la relacion entre el Cliente-Servicio,
 * se tienen los meses, el plan, si esta activo el plan.
 * Su uso principal es calcular los cobros y llevar el conteo mensual de la simulacion.
 * 
 * @author Espora equipo 
 * @version 1.0
 */

public class Suscripcion {

    private int meses;
    private TarifaEstrategia tarifa; 
    private boolean isActiva;
    private Sujeto planSuscripcion;


    /**
     * Constructor de la clase Suscripcion
     * 
     * @param meses Meses de la suscripcion 
     * @param tarifa tarifa por servicio de plataforma
     * @param isActiva Boolean que verifica si es o no activa la suscripcion 
     * @param planSuscripcion Plataforma que se esta contratando
     * 
     */

    public Suscripcion (int meses,TarifaEstrategia tarifa, boolean isActiva, Sujeto planSuscripcion) {
        this.meses = meses;
        this.tarifa = tarifa;
        this.isActiva = isActiva;
        this.planSuscripcion = planSuscripcion;

    }

    /**
     * Getters de la clase Suscripcion
     * 
     * @return Para getServicio el servicio (Sujeto) que pertenece a la suscripcion
     */

    public Sujeto getServicio(){
        return planSuscripcion;
    }

    
}
