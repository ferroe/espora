package mx.unam.fciencias.espora.practica1;

/**
 * Clase para Suscripcion
 * 
 * En esta clase se tiene la relación entre el cliente y el servicio, en el que 
 * se gestiona la suscripcion a la plataforma junto con su tarifa 
 * dependiendo de los meses.
 * 
 * @author Equipo Espora
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
     * @param meses Meses de la suscripcion que se inicializa en 0
     * @param tarifa Tarifa por servicio de plataforma
     * @param isActiva Boolean que verifica si es o no activa la suscripcion inicializada en true 
     * @param planSuscripcion Plan de la plataforma que se esta contratando
     */
    public Suscripcion (int meses, TarifaEstrategia tarifa, boolean isActiva, Sujeto planSuscripcion) {
        this.meses = 0;
        this.tarifa = tarifa;
        this.isActiva = true;
        this.planSuscripcion = planSuscripcion;
    }

    /**
     * Getter de la clase Suscripcion
     * @return Tomamos el plan de la suscripcion.
     */
    public Sujeto getServicio(){
        return planSuscripcion;
    }

    /**
     * Nos dice los meses acumulados por suscripcion.
     *  
     * @return Devuelve los meses
     */
    public int getMeses(){
        return meses;
    }

    /**
     * Nos da la estrategia de cobro requerida
     * 
     * @return Devuelve la estrategia de la tarifa que se esta usando
     */
    public TarifaEstrategia getTarifa(){
        return tarifa;
    } 

    /** 
     * Se tiene el valor de la tarifa de la suscripcion
    */
    public void setTarifa(TarifaEstrategia tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Nos dice si la suscripcion esta activa para los cobros y notificaciones.
     * 
     * @return Devuelve true o false dependiendo si la suscripcion 
     * es activa o no
     */
    public boolean getIsActiva(){
        return isActiva;
    }
    
    /**
     * Aqui guardamos el valor de true o false
     */    
    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }

    /**
     * Se crea el contador de los meses, y los va incrementando.
     */
    public void incrementarMes() {
        this.meses++;
    }
}
