package mx.unam.fciencias.espora.practica3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para los grupos.
 * 
 * Esta clase va a representar a un grupo de acuerdo
 * a la forma en la que se especifico en la practica.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Grupo {

    private Voluntario liderGrupo;
    private List<Prospecto> integrantes = new ArrayList<Prospecto>();
    private Paquete paquete;
    private CampoEntrenamiento campo;

    /**
     * Constructor para la clase Grupo.
     * 
     * @param liderGrupo El líder del grupo.
     */
    public Grupo(Voluntario liderGrupo) {
        this.liderGrupo = liderGrupo;
    }

    /**
     * Metodo que regresa el líder del grupo.
     * 
     * @return El líder del grupo.
     */
    public Voluntario getLiderGrupo() {
        return liderGrupo;
    }

    /**
     * Metodo que regresa los integrantes del grupo.
     * 
     * @return Los integrantes del grupo.
     */
    public List<Prospecto> getIntegrantes() {
        return integrantes;
    }

    /**
     * Metodo que regresa el paquete del grupo.
     * 
     * @return El paquete del grupo.
     */
    public Paquete getPaquete() {
        return paquete;
    }

    /**
     * Metodo que regresa el campo de entrenamiento del grupo.
     * 
     * @return El campo de entrenamiento del grupo.
     */
    public CampoEntrenamiento getCampo() {
        return campo;
    }

    /**
     * Metodo que agrega un integrante al grupo.
     * 
     * @param prospecto El prospecto a agregar.
     */
    public void agregarIntegrante(Prospecto prospecto) {
        this.integrantes.add(prospecto);
    }

    /**
     * Metodo que establece el paquete del grupo.
     * 
     * @param paquete El paquete a establecer.
     */
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    /**
     * Metodo que establece el campo de entrenamiento del grupo.
     * 
     * @param campo El campo de entrenamiento a establecer.
     */
    public void setCampo(CampoEntrenamiento campo) {
        this.campo = campo;
    }

    /**
     * Metodo que calcula el nivel de habilidad total del grupo.
     * 
     * @return El nivel de habilidad total del grupo.
     */
    public int getNivelHabilidadTotal() {
        int total = this.liderGrupo.getNivelHabilidad();
        for (Prospecto integrante : this.integrantes) {
            total += integrante.getNivelHabilidad();
        }
        return total;
    }

    /**
     * Método que devuelve una representación en cadena del grupo.
     *
     * @return Una cadena que representa al grupo.
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        if (liderGrupo != null) {
            cadena.append("Líder del grupo: ").append(liderGrupo.getNombre()).append("\n");
            cadena.append("Rango: ").append(liderGrupo.getRango()).append("\n");
            cadena.append("Nivel de habilidad: ").append(liderGrupo.getNivelHabilidad()).append("\n");
        }

        if (integrantes.isEmpty()) {
            cadena.append("No hay integrantes en el grupo.\n");
        } else {
            cadena.append("Integrantes del grupo:\n");
            for (Prospecto integrante : integrantes) {
                cadena.append("- ").append(integrante.getNombre()).append("\n");
                cadena.append("Nivel de habilidad: ").append(integrante.getNivelHabilidad()).append("\n");
            }
        }

        if (paquete != null) {
            cadena.append(paquete.toString()).append("\n");
        } else {
            cadena.append("No hay paquete asignado.\n");
        }

        if (campo != null) {
            cadena.append("Campo de entrenamiento asignado: ").append(campo.getNombre()).append("\n");
            cadena.append("Descripción: ").append(campo.getDescripcion()).append("\n");
        } else {
            cadena.append("No hay campo de entrenamiento asignado.\n");
        }

        return cadena.toString();
    }
}
