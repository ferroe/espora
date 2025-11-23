package mx.unam.fciencias.espora.proyecto2.modelo;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EcosistemaLoader {

    /**
     * Carga el escenario predeterminado (default.json).
     * @return Un EcosistemaInterfaz poblado y listo.
     */
    public static EcosistemaInterfaz cargarDefault() {
        String archivo = "default.json";
        // CORRECCIÓN: Usar "resources" (estándar Maven) a menos que hayas renombrado la carpeta
        String rutaCompleta = "src/main/resources/" + archivo;
        
        Ecosistema ecosistema = new Ecosistema();

        try {
            System.out.println("Cargando escenario default desde: " + rutaCompleta);
            
            String contenido = new String(Files.readAllBytes(Paths.get(rutaCompleta)));
            JSONObject json = new JSONObject(contenido);

            // 1. LEER CONFIGURACIÓN CLIMÁTICA
            JSONObject config = json.getJSONObject("configuracionGlobal");
            JSONObject clima = config.getJSONObject("promediosClima");
            
            double[] precipitacion = jsonArrayToDouble(clima.getJSONArray("precipitacion"));
            double[] temperatura = jsonArrayToDouble(clima.getJSONArray("temperatura"));
            double evapBase = clima.getDouble("evaporacionBase");

            // --- CORRECCIÓN CRÍTICA ---
            // Eliminamos la configuración global porque ecosistema.getModeloParametros() es null.
            // Los parámetros ahora viven dentro de cada Zona.

            // 2. CONFIGURAR ZONAS Y POBLACIONES
            ZonaEcosistema raiz = ecosistema.getXochimilcoRaiz();
            JSONArray zonasArray = json.getJSONArray("zonas");

            for (int i = 0; i < zonasArray.length(); i++) {
                JSONObject zonaObj = zonasArray.getJSONObject(i);
                String nombreZona = zonaObj.getString("nombre");
                
                // Crear la Zona
                ZonaEcosistema nuevaZona = new ZonaEcosistema(nombreZona);

                // APLICAR CLIMA A LA ZONA (Localmente)
                nuevaZona.getParametros().setPromediosClima(precipitacion, temperatura, evapBase);
                nuevaZona.getParametros().setNivelContaminacion(0.1); // Valor inicial
                
                // Cargar poblaciones
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
            System.err.println("ERROR CRÍTICO: No se pudo leer " + rutaCompleta);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ERROR EN EL JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return ecosistema;
    }

    // --- MÉTODOS PRIVADOS DE AYUDA ---

    private static double[] jsonArrayToDouble(JSONArray arr) {
        double[] res = new double[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            res[i] = arr.getDouble(i);
        }
        return res;
    }

    private static void asignarEstrategia(PoblacionEspecie p, String nombre) {
        if (nombre.contains("Ajolote")) {
            p.setEstrategia(new EstrategiaAjolote());
        } else if (nombre.contains("Pato")) {
            p.setEstrategia(new EstrategiaPatoMexicano());
        } else if (nombre.contains("Rana")) {
            p.setEstrategia(new EstrategiaRanaMoctezuma());
        }
    }
    
    private static void asignarEstadoInicial(PoblacionEspecie p, String estado) {
        if (estado.equalsIgnoreCase("Crítico")) {
            p.actualizarEstado(p.getEstadoCritico());
        } else if (estado.equalsIgnoreCase("En Riesgo")) {
            p.actualizarEstado(p.getEstadoRiesgo());
        } else {
            p.actualizarEstado(p.getEstadoSaludable());
        }
    }
}