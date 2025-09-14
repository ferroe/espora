package mx.unam.fciencias.espora.practica2;

import java.util.Scanner;

/**
 * Clase principal para simular el funcionamiento de la pizzería y el robot.
 * Contiene el menú interactivo para que el cliente realice su orden.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class PizzeriaCesarin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();
        boolean salir = false;

        System.out.println("--- Bienvenido a la Pizzería 'El Pequeño Cesarín' --- \n");

        // Llega el primer cliente y llama al robot
        System.out.println("Un robot atenderá tu orden. Para comenzar, llama al robot");
        System.out.print("... El cliente llama al robot ...\n");
        robot.llamar();

        // Llega otro cliente y tambien llama al robot
        System.out.println("... Otro cliente llega y llama al robotcin ...");
        robot.llamar();

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Pedir pizza");
            System.out.println("2. Pedir helado");
            System.out.println("3. Confirmar orden");
            System.out.println("4. Cancelar orden");
            System.out.println("5. Solicitar entrega de pedido listo");
            System.out.println("0. Salir de la pizzería");
            System.out.print("Elige una opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número");
                continue;
            }

            switch (opcion) {
                case 1:
                    Pizza pizzaElegida = elegirPizza(scanner);
                    robot.ordenarPedido(pizzaElegida);
                    break;
                case 2:
                    Helado heladoElegido = elegirHelado(scanner);
                    robot.ordenarPedido(heladoElegido);
                    break;
                case 3:
                    robot.confirmarOrden();
                    robot.iniciarPreparacion();
                    break;
                case 4:
                    if (robot.cancelarOrden()) {
                        System.out.println("\nListo para un nuevo cliente. Llama al robot para empezar.");
                        robot.llamar();
                    }
                    break;
                case 5:
                    if (robot.solicitarEntrega()) {
                        System.out.println("\nListo para un nuevo cliente. Llama al robot para empezar.");
                        robot.llamar();
                    }
                    break;
                case 0:
                    salir = true;
                    System.out.println("Gracias por visitarnos. ¡Vuelve pronto!");
                    break;
                default:
                    System.out.println("Ingresa una opción válida");
                    break;
            }
        }
        scanner.close();
    }

    private static Pizza elegirPizza(Scanner scanner) {
        Pizza[] menuPizzas = {
            new PizzaHawaiana(), new PizzaMargarita(), new PizzaPeperoni(),
            new PizzaPollo(), new PizzaSalchicha()
        };

        while (true) {
            System.out.println("\n--- Menú de Pizzas ---");
            for (int i = 0; i < menuPizzas.length; i++) {
                System.out.println((i + 1) + ". " + menuPizzas[i].getInfoTicket());
            }
            System.out.print("Elige una pizza: ");
            
            try {
                int opcionPizza = Integer.parseInt(scanner.nextLine());
                if (opcionPizza > 0 && opcionPizza <= menuPizzas.length) {
                    return menuPizzas[opcionPizza - 1];
                } else {
                    System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresar un número");
            }
        }
    }

    private static Helado elegirHelado(Scanner scanner) {
        Helado helado = elegirSaborBase(scanner);
        
        int toppingsAgregados = 0;

        while (true) {
            System.out.print("Añade un topping (" + (3 - toppingsAgregados) + " restantes) o introduce 'listo': ");
            String topping = scanner.nextLine().toLowerCase();

            if (topping.equals("listo")) {
                break;
            }

            if (toppingsAgregados >= 3) {
                System.out.println("Ya has añadido el máximo de 3 toppings");
                continue;
            }

            boolean toppingValidoAnadido = true;
            switch (topping) {
                case "kiwis": 
                    helado = new Kiwis(helado); break;
                case "manguitos": 
                    helado = new Manguitos(helado); break;
                case "malvaviscos": 
                    helado = new Malvaviscos(helado); break;
                case "fresitas": 
                    helado = new Fresitas(helado); break;
                case "gomitas panda": 
                    helado = new GomitasPanda(helado); break;
                case "gomitas gusano": 
                    helado = new GomitasGusano(helado); break;
                case "gomitas aro": 
                    helado = new GomitasAro(helado); break;
                case "chispas chocolate": 
                    helado = new ChispasChocolate(helado); break;
                default:
                    System.out.println("Pide un topping válido");
                    toppingValidoAnadido = false;
            }
            
            if (toppingValidoAnadido) {
                toppingsAgregados++;
                System.out.println(topping + " añadido. Tu helado: " + helado.getInfoTicket());
            }
        }
        return helado;
    }

    private static Helado elegirSaborBase(Scanner scanner) {
        Helado[] menuSabores = { new HeladoFresa(), new HeladoVainilla(), new HeladoChocolate() };

        while (true) {
            System.out.println("\n--- Menú de Sabores de Helado ---");
            for (int i = 0; i < menuSabores.length; i++) {
                System.out.println((i + 1) + ". " + menuSabores[i].getInfoTicket());
            }
            System.out.print("Elige un sabor base: ");
            
            try {
                int opcionSabor = Integer.parseInt(scanner.nextLine());
                if (opcionSabor > 0 && opcionSabor <= menuSabores.length) {
                    return menuSabores[opcionSabor - 1];
                } else {
                    System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número");
            }
        }
    }
}