package mx.unam.fciencias.espora.practica3;

/**
 * Clase para CampoEntrenamientoFactory
 * 
 * Esta clase es una fábrica que crea instancias de diferentes campos de entrenamiento
 * basándose en la suma del nivel de habilidad de los integrantes del grupo.
 *
 * @author Equipo Espora
 * @version 1.0
 */

public class CampoEntrenamientoFactory {

    /**
     * Método estático que crea un campo de entrenamiento basado en el nivel de habilidad.
     *
     * @param nivelHabilidad La suma del nivel de habilidad de los integrantes del grupo.
     * @return Una instancia del campo de entrenamiento adecuado.
     * @throws IllegalArgumentException Si el nivel de habilidad es menor o igual a 0.
     */
    public static CampoEntrenamiento crearCampo(int nivelHabilidad) {
        if(nivelHabilidad <= 0) {
            throw new IllegalArgumentException("El nivel de habilidad debe ser positivo");
        }

        if(nivelHabilidad <= 7) {
            return new ValleDelDragon();
        } else if (nivelHabilidad > 7 && nivelHabilidad <= 11) {
            return new BosqueSombrio();
        } else {
            return new MontanaEspiritual();
        }
    }
}
