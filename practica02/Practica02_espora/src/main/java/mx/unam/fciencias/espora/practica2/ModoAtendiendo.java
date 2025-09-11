package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoAtendiendo 
 * Esta clase implementa el estado del robot y atiende a los cliente.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoAtendiendo implements EstadoRobot{

    private Robot robot;

    /**
     * Constructor de la clase ModoAtendiendo
     * @param robot 
     */
    public ModoAtendiendo(Robot robot){
        this.robot = robot;
    }

    /**
     * Metodo para cambiar el estado del robot a dormir
     */
    @Override
    public void dormir() {
        System.out.println("Atendiendo: Termina de atender y se va a dormir");
        robot.setModo(robot.getModoDormido());
    }

    /**
     * Metodo para cambiar el estado del robot a atender
     */
    @Override
    public void atender() {
        System.out.println("Atendiendo: El robot esta atendiendo");
        robot.setModo(robot.getModoAtendiendo());
    }

    /**
     * Metodo para cambiar el estado del robot a cocinar
     */
    @Override
    public void cocinar() {
        System.out.println("Atendiendo: El robot pasa a cocinando");
    }

    /**
     * Metodo para cambiar el estado del robot a repartir
     */
    @Override
    public void repartir() {
        System.out.println("Atendiendo: El robot no puede repartir directamente, primero debe cocinar");
    }   
}
