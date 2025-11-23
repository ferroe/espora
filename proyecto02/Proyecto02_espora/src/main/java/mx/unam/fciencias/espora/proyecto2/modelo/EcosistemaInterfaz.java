package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * La interfaz principal del Modelo.
 * Define los métodos para controlar la simulación (Controlador)
 * y para leer el estado (Vista).
 */
public interface EcosistemaInterfaz extends Sujeto {
    
    // --- Métodos del Patrón Observer ---
    void registrarObservador(Observer o);
    void removerObservador(Observer o);
    
    // --- Métodos de Lectura (Getters para la Vista) ---
    ZonaEcosistema getXochimilcoRaiz();
    ModeloParametros getModeloParametros();
    // ...
    ZonaEcosistema buscarZona(String nombre);
    
    // --- Métodos de Lógica / Acción (Para el Controlador) ---
    void simularPasoDelTiempo();
    
    void limpiarZona(String nombreZona);
    void repoblarEspecie(String nombreZona, String nombreEspecie);
    void restaurarFlora(String nombreZona);
    void tirarBasura(String nombreZona);
    void introducirInvasoras(String nombreZona);
}