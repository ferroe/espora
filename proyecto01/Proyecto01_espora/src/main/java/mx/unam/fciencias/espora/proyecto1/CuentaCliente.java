package mx.unam.fciencias.espora.proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase que modela una Cuenta de un cliente
 *
 * @author Equipo Espora
 * @version 1.0
 */

public class CuentaCliente implements Cuenta, Sujeto {

    private InteresEstrategia estrategia;
    private EstadoCuenta estadoActual;
    private EstadoCuenta estadoActiva;
    private EstadoCuenta estadoSobregirada;
    private EstadoCuenta estadoCongelada;
    private EstadoCuenta estadoCerrada;
    private List<Observador> observadores;

    private final TipoCuenta tipoCuenta;
    private double saldo;
    private int antiguedadMeses;
    private double sumaSaldosPromedio;
    private int mesesPromedio;
    private final String numCuenta;
    private final List<String> historialOperaciones;
    private final String idCliente;

    /**
     * Constructor de la clase CuentaCliente
     *
     * @param numCuenta   El número de cuenta
     * @param idCliente   El ID del cliente dueño
     * @param tipoCuenta  El tipo de cuenta
     * @param saldo       El saldo inicial
     * @param estado      El estado inicial
     * @param antiguedad  La antigüedad en meses
     * @param sumaSaldos  La suma de saldos para el promedio anual
     * @param estrategia  La estrategia de interés
     */
    public CuentaCliente(String numCuenta, String idCliente, TipoCuenta tipoCuenta, double saldo,
                         String estado, int antiguedad, double sumaSaldos,
                         InteresEstrategia estrategia) {
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.antiguedadMeses = antiguedad;
        this.sumaSaldosPromedio = sumaSaldos;
        this.mesesPromedio = antiguedad % 12;
        this.estrategia = estrategia;

        this.historialOperaciones = new ArrayList<>();
        this.observadores = new ArrayList<>();

        this.estadoActiva = new EstadoActiva(this);
        this.estadoSobregirada = new EstadoSobregirada(this);
        this.estadoCongelada = new EstadoCongelada(this);
        this.estadoCerrada = new EstadoCerrada(this);

        switch (estado.toUpperCase()) {
            case "SOBREGIRADA":
                this.estadoActual = this.estadoSobregirada;
                break;
            case "CONGELADA":
                this.estadoActual = this.estadoCongelada;
                break;
            case "CERRADA":
                this.estadoActual = this.estadoCerrada;
                break;
            case "ACTIVA":
            default:
                if (this.saldo < 0) {
                    this.estadoActual = this.estadoSobregirada;
                } else {
                    this.estadoActual = this.estadoActiva;
                }
        }
    }

    /**
     * Realiza una compra 
     * @param monto El monto a comprar
     * @return true si la compra fue exitosa, false en caso contrario
     */
    @Override
    public boolean comprar(double monto) {
        return estadoActual.comprar(monto);
    }

    /**
     * Deposita en la cuenta
     * @param monto El monto a depositar
     */
    @Override
    public void depositar(double monto) {
        estadoActual.depositar(monto);
    }

    /**
     * Genera los intereses de la cuenta
     */
    @Override
    public void generarIntereses() {
        estadoActual.generarIntereses();
    }

    /**
     * Bloquea la cuenta
     */
    @Override
    public void bloquearCuenta() {
        estadoActual.bloquearCuenta();
    }

    /**
     * Desbloquea la cuenta
     */
    @Override
    public void desbloquearCuenta() {
        estadoActual.desbloquearCuenta();
    }

    /**
     * Suspende la cuenta
     */
    @Override
    public void suspenderCuenta() {
        estadoActual.suspenderCuenta();
    }

    /**
     * Reabre la cuenta
     */
    @Override
    public void reabrirCuenta() {
        estadoActual.reabrirCuenta();
    }

    /**
     * Realiza el cargo mensual de la cuenta
     */
    @Override
    public void cargoMensual() {
        estadoActual.cargoMensual();
    }

    /**
     * Registra un observador
     * @param cliente Observador a registrar
     */
    @Override
    public void registrar(Observador cliente) {
        this.observadores.add(cliente);
    }

    /**
     * Remueve un observador
     * @param cliente Observador a remover
     */
    @Override
    public void remover(Observador cliente) {
        this.observadores.remove(cliente);
    }

    /**
     * Notifica a los observadores
     */
    @Override
    public void notificarObservadores() {
        String resumen = generarResumenMensual();
        for (Observador obs : observadores) {
            obs.actualizar(resumen);
        }
    }

    /**
     * Método auxiliar para generar el resumen mensual
     * de operaciones y saldo
     */
    private String generarResumenMensual() {
        StringBuilder resumen = new StringBuilder();
        
        resumen.append("--- Resumen Mensual Cuenta: ").append(numCuenta).append(" ---\n");
        
        resumen.append("Operaciones del mes:\n");
        if (historialOperaciones.isEmpty()) {
            resumen.append("  (No hubo operaciones este mes)\n");
        } else {
            for (String operacion : historialOperaciones) {
                resumen.append("  - ").append(operacion).append("\n");
            }
        }
        
        resumen.append("Saldo final: $").append(String.format("%.2f", this.saldo)).append("\n");
        resumen.append("------------------------------------------");

        return resumen.toString();
    }

    /**
     * Obtiene el saldo de la cuenta
     * @return El saldo actual
     */
    @Override
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene el número de cuenta
     * @return El número de cuenta
     */
    @Override
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Obtiene el historial de operaciones
     * @return El historial de operaciones
     */
    @Override
    public List<String> getHistorial() {
        return new ArrayList<>(historialOperaciones);
    }

    /**
     * Obtiene el ID del cliente dueño de la cuenta
     * @return El ID del cliente
     */
    @Override
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Asigna un nuevo estado a la cuenta 
     * @param nuevoEstado El nuevo estado a asignar
     */
    public void asignarEstado(EstadoCuenta nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    /**
     * Asigna un nuevo saldo a la cuenta
     * @param nuevoSaldo El nuevo saldo a asignar
     */
    public void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    /**
     * Registra una operación en el historial
     * @param descripcion La descripción de la operación
     */
    public void registrarOperacion(String descripcion) {
        this.historialOperaciones.add(LocalDate.now() + ": " + descripcion);
    }

    /**
     * Obtiene el estado Activa
     * @return El estado Activa
     */
    public EstadoCuenta getEstadoActiva() { 
        return estadoActiva; 
    }

    /**
     * Obtiene el estado Sobregirada
     * @return El estado Sobregirada
     */
    public EstadoCuenta getEstadoSobregirada() { 
        return estadoSobregirada; 
    }

    /**
     * Obtiene el estado Congelada
     * @return El estado Congelada
     */
    public EstadoCuenta getEstadoCongelada() { 
        return estadoCongelada; 
    }

    /**
     * Obtiene el estado Cerrada
     * @return El estado Cerrada
     */
    public EstadoCuenta getEstadoCerrada() { 
        return estadoCerrada; 
    }

    /**
     * Obtiene la estrategia de interés
     * @return La estrategia de interés
     */
    public InteresEstrategia getEstrategia() {
        return this.estrategia;
    }

    /**
     * Asigna una nueva estrategia de interés
     * @param nuevaEstrategia La nueva estrategia a asignar
     */
    public void setEstrategia(InteresEstrategia nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }

    /**
     * Obtiene la antigüedad en meses de la cuenta
     * @return La antigüedad en meses
     */
    public int getAntiguedadMeses() {
        return antiguedadMeses;
    }

    /**
     * Obtiene la suma de saldos para el cálculo del promedio anual
     * @return La suma de saldos para el promedio anual
     */
    public double getSumaSaldosPromedio() {
        return sumaSaldosPromedio;
    }

    /**
     * Obtiene los meses promedio para el cálculo del promedio anual
     * @return Los meses promedio para el cálculo del promedio anual
     */
    public int getMesesPromedio() {
        return mesesPromedio;
    }

    /**
     * Obtiene el tipo de cuenta
     * @return El tipo de cuenta
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Reinicia los valores del promedio anual
     */
    public void reiniciarPromedioAnual() {
        this.mesesPromedio = 0;
        this.sumaSaldosPromedio = 0.0;
    }

    /**
     * Avanza un mes en la cuenta, actualizando antigüedad y promedios
     */
    public void avanzarMes() {
        this.antiguedadMeses++;
        this.mesesPromedio++;
        this.sumaSaldosPromedio += this.saldo;
    }

    /**
     * Obtiene el nombre del estado de la cuenta
     * @return Nombre del estado de la cuenta
     */
    public String getNombreEstado() {
        return estadoActual.getNombreEstado();
    }
}