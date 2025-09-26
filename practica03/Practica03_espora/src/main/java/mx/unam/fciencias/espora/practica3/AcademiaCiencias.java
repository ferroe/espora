package mx.unam.fciencias.espora.practica3;

import java.util.Scanner;

/**
 * Clase que representa la Academia de Ciencias.
 * 
 * Esta clase es responsable de simular las actividades de la academia,
 * incluyendo la formación de grupos de voluntarios y prospectos,
 * su asignación de paquetes y campo de entrenamiento.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class AcademiaCiencias {

    private GrupoVoluntario grupoVoluntarios;
    private GrupoProspecto grupoProspectos;

    /**
     * Constructor de la clase AcademiaCiencias.
     * Inicializa los grupos de voluntarios y prospectos.
     */
    public AcademiaCiencias() {
        grupoVoluntarios = new GrupoVoluntario();
        grupoProspectos = new GrupoProspecto();
    }

    /**
     * Método principal para iniciar las actividades de la academia.
     */
    public void iniciarActividades() {
        System.out.println("--- Iniciando dia de actividades ---\n");
        formarGrupos();
        System.out.println("--- Gracias por venir ---");
    }

    /**
     * Método auxiliar que forma los grupos de voluntarios y prospectos.
     */
    private void formarGrupos() {
        Scanner scanner = new Scanner(System.in);

        Iterator iteradorVoluntarios = grupoVoluntarios.crearIterador();
        Iterator iteradorProspectos = grupoProspectos.crearIterador();

        System.out.println("--- Formando los grupos ---\n");
        int numGrupo = 1;

        while (iteradorVoluntarios.hasNext() && iteradorProspectos.hasNext()) {
            Voluntario lider = (Voluntario) iteradorVoluntarios.next();
            Grupo grupo = new Grupo(lider);

            int capacidad = 0;
            switch (lider.getRango()) {
                case "Genin":
                    capacidad = 1;
                    break;
                case "Chunin":
                    capacidad = 2;
                    break;
                case "Jonin":
                    capacidad = 3;
                    break;
                default:
                    break;
            }

            for (int i = 0; i < capacidad; i++) {
                if (iteradorProspectos.hasNext()) {
                    grupo.agregarIntegrante((Prospecto) iteradorProspectos.next());
                } else {
                    break;
                }
            }

            asignarPaquete(grupo, scanner);
            asignarCampoEntrenamiento(grupo);


            System.out.println("--- Grupo: " + numGrupo + " Formado exitosamente ---");
            System.out.println(grupo.toString());
            System.out.println("-----------------------------\n");
            numGrupo++;
        }

        sinCupo(iteradorProspectos);
        scanner.close();
    }

    /**
     * Metodo auxiliar para elegir un paquete y asignarlo a un grupo.
     * 
     * @param grupo El grupo al que se le asignará el paquete.
     * @param scanner El scanner para leer la entrada del usuario.
     */
    private void asignarPaquete(Grupo grupo, Scanner scanner) {
        System.out.println("--- Asignacion de Paquete para el grupo de " + grupo.getLiderGrupo().getNombre() + " ---");
        System.out.println("1. Paquete Prefabricado");
        System.out.println("2. Paquete Personalizado");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            asignarPaquetePrefabricado(grupo, scanner);
        } else {
            asignarPaquetePersonalizado(grupo, scanner);
        }
    }

    /**
     * Metodo auxiliar para asignar un paquete prefabricado a un grupo.
     * 
     * @param grupo El grupo al que se le asignará el paquete.
     * @param scanner El scanner para leer la entrada del usuario.
     */
    private void asignarPaquetePrefabricado(Grupo grupo, Scanner scanner) {
        System.out.println("\n--- Elige un Paquete Prefabricado ---");
        System.out.println("1. Basico");
        System.out.println("2. Avanzado");
        System.out.println("3. Tactico");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                PaqueteBasicoBuilder basicoBuilder = new PaqueteBasicoBuilder();
                basicoBuilder.construirPaquete();
                grupo.setPaquete(basicoBuilder.getPaquete());
                break;
            case 2:
                PaqueteAvanzadoBuilder avanzadoBuilder = new PaqueteAvanzadoBuilder();
                avanzadoBuilder.construirPaquete();
                grupo.setPaquete(avanzadoBuilder.getPaquete());
                break;
            case 3:
                PaqueteTacticoBuilder tacticoBuilder = new PaqueteTacticoBuilder();
                tacticoBuilder.construirPaquete();
                grupo.setPaquete(tacticoBuilder.getPaquete());
                break;
            default:
                System.out.println("Opción no válida. Se asignará Paquete Basico por defecto.");
                PaqueteBasicoBuilder builderDefecto = new PaqueteBasicoBuilder();
                builderDefecto.construirPaquete();
                grupo.setPaquete(builderDefecto.getPaquete());
                break;
        }
        System.out.println("Paquete asignado con éxito.\n");
    }

    /**
     * Metodo auxiliar para que el usuario construya un paquete personalizado para un grupo.
     * 
     * @param grupo El grupo al que se le asignará el paquete.
     * @param scanner El scanner para leer la entrada del usuario.
     */
    private void asignarPaquetePersonalizado(Grupo grupo, Scanner scanner) {
        PaquetePersonalizadoBuilder builder = new PaquetePersonalizadoBuilder();
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n--- Creador de Paquete Personalizado ---");
            System.out.println("1. Añadir Kunai");
            System.out.println("2. Añadir Shuriken");
            System.out.println("3. Añadir Papel Bomba");
            System.out.println("4. Añadir Bomba de Humo");
            System.out.println("5. Añadir Botiquin");
            System.out.println("9. Terminar y crear paquete");
            System.out.print("Elige una herramienta para añadir: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("¿Cuantas herramientas quieres añadir?: ");
                int cantidad = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        for (int i = 0; i < cantidad; i++)
                            builder.addHerramienta(new Kunai());
                        break;
                    case 2:
                        for (int i = 0; i < cantidad; i++)
                            builder.addHerramienta(new Shuriken());
                        break;
                    case 3:
                        for (int i = 0; i < cantidad; i++)
                            builder.addHerramienta(new PapelBomba());
                        break;
                    case 4:
                        for (int i = 0; i < cantidad; i++)
                            builder.addHerramienta(new BombaHumo());
                        break;
                    case 5:
                        for (int i = 0; i < cantidad; i++)
                            builder.addHerramienta(new Botiquin());
                        break;
                    default:
                        break;
                }
                System.out.println(cantidad + " herramienta(s) añadida(s)");
            } else if (opcion != 9) {
                System.out.println("\nOpción no válida, ingresa una opción del 1 al 5, o 9 para terminar");
            }
        }
        grupo.setPaquete(builder.getPaquete());
        System.out.println("Paquete personalizado creado y asignado con exito\n");
    }

    /**
     * Metodo auxiliar que asigna un campo de entrenamiento a un grupo.
     *
     * @param grupo El grupo al que se le asignará el campo.
     */
    private void asignarCampoEntrenamiento(Grupo grupo) {
        int nivelTotal = grupo.getNivelHabilidadTotal();
        CampoEntrenamiento campo = CampoEntrenamientoFactory.crearCampo(nivelTotal);
        grupo.setCampo(campo);
    }

    /**
     * Metodo auxiliar que notifica a los aspirantes que no pudieron ser asignados a un grupo.
     * 
     * @param iteradorProspectos El iterador de aspirantes después de formar todos los grupos.
     */
    private void sinCupo(Iterator iteradorProspectos) {
        if (iteradorProspectos.hasNext()) {
            System.out.println("--- Aviso ---");
            System.out.println("Vickage: Una disculpa a los siguientes aspirantes, no había más líderes disponibles:");

            while (iteradorProspectos.hasNext()) {
                Prospecto sobrante = (Prospecto) iteradorProspectos.next();
                System.out.println("- " + sobrante.getNombre());
            }
            System.out.println("-----------------------------\n");
        }
    }

    /**
     * Metodo main para iniciar la aplicacion.
     * 
     * @param args Argumentos de la linea de comandos (no se usan).
     */
    public static void main(String[] args) {
        AcademiaCiencias academia = new AcademiaCiencias();
        academia.iniciarActividades();
    }
}
