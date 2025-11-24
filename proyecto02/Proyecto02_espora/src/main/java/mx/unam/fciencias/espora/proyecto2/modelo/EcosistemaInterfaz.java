package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * La interfaz principal del Modelo.
 * Define los metodos para controlar la simulacion (Controlador)
 * y para leer el estado (Vista).
 *
 */
public interface EcosistemaInterfaz extends Sujeto {
     /**
      * Registra un observador para recibir notificaciones del modelo.
      * @param o Observador a registrar.
      */
     void registrarObservador(Observer o);

     /**
      * Remueve un observador previamente registrado.
      * @param o Observador a remover.
      */
     void removerObservador(Observer o);

     /**
      * Devuelve la raiz del arbol de zonas de Xochimilco.
      * @return Zona raiz del ecosistema.
      */
     ZonaEcosistema getXochimilcoRaiz();

     /**
      * Obtiene los parametros del modelo usados en la simulacion.
      * @return Objeto con parametros del modelo.
      */
     ModeloParametros getModeloParametros();

     /**
      * Busca y devuelve la zona con el nombre indicado.
      * @param nombre Nombre de la zona a buscar.
      * @return Zona encontrada o null si no existe.
      */
     ZonaEcosistema buscarZona(String nombre);

     /**
      * Realiza un paso de simulacion, actualizando estados y notificando observadores.
      */
     void simularPasoDelTiempo();

     /**
      * Limpia la zona especificada aplicando acciones de conservacion.
      * @param nombreZona Nombre de la zona a limpiar.
      */
     void limpiarZona(String nombreZona);

     /**
      * Repuebla la especie indicada en la zona especificada.
      * @param nombreZona Zona donde repoblar.
      * @param nombreEspecie Nombre de la especie a repoblar.
      */
     void repoblarEspecie(String nombreZona, String nombreEspecie);

     /**
      * Restaura la flora de la zona indicada.
      * @param nombreZona Nombre de la zona a restaurar.
      */
     void restaurarFlora(String nombreZona);

     /**
      * Simula el tiradero de basura en la zona indicada.
      * @param nombreZona Nombre de la zona afectada.
      */
     void tirarBasura(String nombreZona);

     /**
      * Introduce especies invasoras en la zona indicada.
      * @param nombreZona Nombre de la zona donde introducir invasoras.
      */
     void introducirInvasoras(String nombreZona);
}