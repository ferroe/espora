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
    private Cliente cliente;

    /**
     * Constructor de la clase Suscripcion
     * 
     * @param meses Meses de la suscripcion que se inicializa en 0
     * @param tarifa Tarifa por servicio de plataforma
     * @param isActiva Boolean que verifica si es o no activa la suscripcion inicializada en true 
     * @param planSuscripcion Plan de la plataforma que se esta contratando
     */
    public Suscripcion (TarifaEstrategia tarifa, Sujeto planSuscripcion, Cliente cliente) {
        this.meses = 0;
        this.tarifa = tarifa;
        this.isActiva = true;
        this.planSuscripcion = planSuscripcion;
        this.cliente = cliente;
    }

    /**
     * Metodo getter que nos da el servicio.
     * @return Tomamos el plan de la suscripcion.
     */
    public Sujeto getServicio(){
        return planSuscripcion;
    }

    /**
     * Metodo getter que nos da los meses.
     *  
     * @return Devuelve los meses
     */
    public int getMeses(){
        return meses;
    }

    /**
     * Método getter que nos da la tarifa.
     * 
     * @return Devuelve la tarifa que se esta usando
     */
    public TarifaEstrategia getTarifa(){
        return tarifa;
    } 

    /** 
     * Método setter que establece la tarifa.
    */
    public void setTarifa(TarifaEstrategia tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Método getter que nos da si esta activa o no.
     * 
     * @return Devuelve true o false dependiendo si la suscripcion 
     * es activa o no
     */
    public boolean getIsActiva(){
        return isActiva;
    }
    
    /**
     * Método setter que establece si esta activa o no.
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
