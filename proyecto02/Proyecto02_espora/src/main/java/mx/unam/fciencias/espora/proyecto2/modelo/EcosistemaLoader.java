package mx.unam.fciencias.espora.proyecto2.modelo;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utilidad para cargar escenarios del ecosistema desde archivos JSON.
 * Actualmente provee la carga del escenario por defecto ubicado en resources.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class EcosistemaLoader {

    /**
     * Carga el escenario predeterminado (default.json) y construye un Ecosistema
     * poblado con zonas y poblaciones.
     * @return Un EcosistemaInterfaz poblado y listo.
     */
    public static EcosistemaInterfaz cargarDefault() {
        String archivo = "default.json";
        String rutaCompleta = "src/main/resources/" + archivo;
        
        Ecosistema ecosistema = new Ecosistema();

        try {
            System.out.println("Cargando escenario default desde: " + rutaCompleta);

            String contenido = new String(Files.readAllBytes(Paths.get(rutaCompleta)));
            JSONObject json = new JSONObject(contenido);

            JSONObject config = json.getJSONObject("configuracionGlobal");
            JSONObject clima = config.getJSONObject("promediosClima");

            double[] precipitacion = jsonArrayToDouble(clima.getJSONArray("precipitacion"));
            double[] temperatura = jsonArrayToDouble(clima.getJSONArray("temperatura"));
            double evapBase = clima.getDouble("evaporacionBase");

            ZonaEcosistema raiz = ecosistema.getXochimilcoRaiz();
            JSONArray zonasArray = json.getJSONArray("zonas");

            for (int i = 0; i < zonasArray.length(); i++) {
                JSONObject zonaObj = zonasArray.getJSONObject(i);
                String nombreZona = zonaObj.getString("nombre");

                ZonaEcosistema nuevaZona = new ZonaEcosistema(nombreZona);

                nuevaZona.getParametros().setPromediosClima(precipitacion, temperatura, evapBase);
                nuevaZona.getParametros().setNivelContaminacion(0.1);

                JSONArray poblacionesArray = zonaObj.getJSONArray("poblaciones");
                for (int j = 0; j < poblacionesArray.length(); j++) {
                    JSONObject pobObj = poblacionesArray.getJSONObject(j);

                    String nombreEspecie = pobObj.getString("nombre");
                    int pobInicial = pobObj.getInt("poblacionInicial");
                    String estadoInicial = pobObj.getString("estadoInicial");

                    PoblacionEspecie poblacion = new PoblacionEspecie(nombreEspecie, pobInicial, 1.0);

                    asignarEstrategia(poblacion, nombreEspecie);
                    asignarEstadoInicial(poblacion, estadoInicial);

                    nuevaZona.agregarComponente(poblacion);
                }

                raiz.agregarComponente(nuevaZona);
            }

            System.out.println("¡Escenario default cargado correctamente!");

        } catch (IOException e) {
            System.err.println("ERROR CRITICO: No se pudo leer " + rutaCompleta);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ERROR EN EL JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return ecosistema;
    }

    /**
     * Convierte un JSONArray de numeros a un arreglo de double.
     * @param arr JSONArray de numeros.
     * @return Arreglo de double.
     */
    private static double[] jsonArrayToDouble(JSONArray arr) {
        double[] res = new double[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            res[i] = arr.getDouble(i);
        }
        return res;
    }

    /**
     * Asigna una estrategia de crecimiento a la poblacion segun su nombre.
     * @param p Poblacion a configurar.
     * @param nombre Nombre de la especie.
     */
    private static void asignarEstrategia(PoblacionEspecie p, String nombre) {
        if (nombre.contains("Ajolote")) {
            p.setEstrategia(new EstrategiaAjolote());
        } else if (nombre.contains("Pato")) {
            p.setEstrategia(new EstrategiaPatoMexicano());
        } else if (nombre.contains("Rana")) {
            p.setEstrategia(new EstrategiaRanaMoctezuma());
        }
    }
    
    /**
     * Configura el estado inicial de la poblacion segun la cadena recibida.
     * @param p Poblacion a configurar.
     * @param estado Cadena con el nombre del estado inicial.
     */
    private static void asignarEstadoInicial(PoblacionEspecie p, String estado) {
        if (estado.equalsIgnoreCase("Critico") || estado.equalsIgnoreCase("Crítico")) {
            p.actualizarEstado(p.getEstadoCritico());
        } else if (estado.equalsIgnoreCase("En Riesgo")) {
            p.actualizarEstado(p.getEstadoRiesgo());
        } else {
            p.actualizarEstado(p.getEstadoSaludable());
        }
    }
}