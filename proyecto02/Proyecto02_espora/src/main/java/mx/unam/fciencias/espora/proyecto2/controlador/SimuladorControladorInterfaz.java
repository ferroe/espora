package mx.unam.fciencias.espora.proyecto2.controlador;

public interface SimuladorControladorInterfaz {
    // Navegación
    void solicitarNavegacionADetalle(String nombreZona);
    void solicitarNavegacionATablero();

    // Acciones de Conservación (Buenas)
    void limpiarZona(String nombreZona);
    void repoblarAjolotes(String nombreZona);
    void restaurarFlora(String nombreZona);

    // Acciones de Deterioro (Malas/Simuladas)
    void tirarBasura(String nombreZona);
    void introducirTilapias(String nombreZona);
}