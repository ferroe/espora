package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoRepartiendo
 * 
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoRepartiendo {

    public Robot robot;

    private ModoRepartiendo(Robot robot) {
        this.robot = robot;
    }

    public void repartir() {
        System.out.println("Repartiendo...");
        robot.setModo(robot.getModoEsperando());
    }


}