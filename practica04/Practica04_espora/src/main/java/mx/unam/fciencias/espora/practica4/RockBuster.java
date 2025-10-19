package mx.unam.fciencias.espora.practica4;

import java.util.Scanner;
import java.time.Year;

/**
 * Clase principal RockBuster.
 * 
 * Representa a la empresa RockBuster y su catalogo de productos
 * de peliculas, sagas de peliculas y albums musicales.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class RockBuster {

    /**
     * Metodo main para ejecutar la aplicacion.
     * 
     * @param args Argumentos de la linea de comandos (no se usan).
     */
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();

        Pelicula ratatoille = new Pelicula("Ratatouille", "Pixar", GeneroPelicula.ANIMADA,
                "Cualquiera puede cocinar", 111, 25.0);
        Pelicula toyStory = new Pelicula("Toy Story", "Pixar", GeneroPelicula.ANIMADA,
                "Andy y sus juguetes", 81, 25.0);
        Pelicula toyStory2 = new Pelicula("Toy Story 2", "Pixar", GeneroPelicula.ANIMADA,
                "El rescate de Woody", 92, 25.0);
        Pelicula toyStory3 = new Pelicula("Toy Story 3", "Pixar", GeneroPelicula.ANIMADA,
                "Desde ese dia algo cambio dentro de lotso...", 103, 30.0);
        Pelicula cars = new Pelicula("Cars", "Pixar", GeneroPelicula.ANIMADA,
                "El inicio de una amistad", 117, 15.0);
        Pelicula cars2 = new Pelicula("Cars 2", "Pixar", GeneroPelicula.ANIMADA,
                "Mate el espia", 106, 20.0);
        Pelicula cars3 = new Pelicula("Cars 3", "Pixar", GeneroPelicula.ANIMADA,
                "El regreso del rayo", 109, 27.0);
        Pelicula juegosDelHambre = new Pelicula("Los Juegos del Hambre", "Gary Ross", GeneroPelicula.AVENTURA,
                "Pelea de tributos", 142, 49.50);
        Pelicula spiderman = new Pelicula("Spiderman", "Sam Raimi", GeneroPelicula.CIENCIA_FICCION,
                "El hombre aracnido", 121, 26.0);
        Pelicula harryPotter = new Pelicula("Harry Potter", "Chris Columbus", GeneroPelicula.FANTASIA,
                "El niño que vivio", 178, 30.0);

        catalogo.agregarProducto(ratatoille);
        catalogo.agregarProducto(toyStory);
        catalogo.agregarProducto(toyStory2);
        catalogo.agregarProducto(toyStory3);
        catalogo.agregarProducto(cars);
        catalogo.agregarProducto(cars2);
        catalogo.agregarProducto(cars3);
        catalogo.agregarProducto(juegosDelHambre);
        catalogo.agregarProducto(spiderman);
        catalogo.agregarProducto(harryPotter);

        Album karma = new Album("Karma", "Stray Kids", GeneroMusical.KPOP,
                Year.of(2023), 250.0);
        Album exodo = new Album("Exodo", "Peso Pluma", GeneroMusical.REGIONAL_MEXICANO,
                Year.of(2023), 500.0);
        Album formula = new Album("Formula, Vol. 3", "Romeo Santos", GeneroMusical.BALADA,
                Year.of(2022), 250.0);

        catalogo.agregarProducto(new AlbumAdapter(karma));
        catalogo.agregarProducto(new AlbumAdapter(exodo));
        catalogo.agregarProducto(new AlbumAdapter(formula));

        Saga toyStorySaga = new Saga("Toy Story Saga", "Pixar", GeneroPelicula.ANIMADA,
                "La saga de Toy Story");
        toyStorySaga.agregarProducto(toyStory);
        toyStorySaga.agregarProducto(toyStory2);
        toyStorySaga.agregarProducto(toyStory3);

        catalogo.agregarProducto(toyStorySaga);

        Saga carsSaga = new Saga("Cars Saga", "Pixar", GeneroPelicula.ANIMADA,
                "La saga de Cars");
        carsSaga.agregarProducto(cars);
        carsSaga.agregarProducto(cars2);
        carsSaga.agregarProducto(cars3);

        catalogo.agregarProducto(carsSaga);

        Saga pixarSaga = new Saga("Pixar Saga", "Pixar", GeneroPelicula.ANIMADA,
                "Los favoritos de Ricardo y Janeth");
        pixarSaga.agregarProducto(toyStorySaga);
        pixarSaga.agregarProducto(carsSaga);
        pixarSaga.agregarProducto(ratatoille);

        catalogo.agregarProducto(pixarSaga);

        RockBuster rockBuster = new RockBuster();
        rockBuster.menu(catalogo);
    }

    /**
     * Muestra el menu principal y ver las opciones disponibles.
     * 
     * @param catalogo El catalogo de productos.
     */
    private void menu(Catalogo catalogo) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.println("--- Bienvenido a RockBuster ---\n");
            System.out.println("1. Ver catalogo completo");
            System.out.println("2. Filtrar por costo maximo");
            System.out.println("3. Filtrar por genero");
            System.out.println("0. Salir");
            int opcion = 0;
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuCatalogo(catalogo, scanner);
                    break;
                case 2:
                    menuCostoMaximo(catalogo, scanner);
                    break;
                case 3:
                    menuPorGenero(catalogo, scanner);
                    break;
                case 0:
                    salir = true;
                    System.out.println("¡Gracias por visitar RockBuster! Vuelva pronto");
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese una opcion del 0 al 3");
            }
            System.out.println();
        }
        scanner.close();
    }

    /**
     * Muestra el menu del catalogo y consultar productos.
     * 
     * @param catalogo El catalogo de productos.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private void menuCatalogo(Catalogo catalogo, Scanner scanner) {
        boolean regresar = false;
        while (!regresar) {
            System.out.println();
            catalogo.verCatalogoCompleto();
            System.out.println(); 
            System.out.println("Selecciona un producto para ver detalles o 0 para regresar: ");
            int opcionProducto = scanner.nextInt();
            scanner.nextLine();

            if (opcionProducto == 0) {
                regresar = true;
                continue;
            }
            ProductoCatalogo productoSeleccionado = catalogo.getProducto(opcionProducto);
            if (productoSeleccionado != null) {
                System.out.println(productoSeleccionado.imprimirProducto());
            } else {
                System.out.println("Producto no encontrado");
            }

        }

    }

    /**
     * Muestra el menu para filtrar por costo maximo.
     * 
     * @param catalogo El catalogo de productos.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private void menuCostoMaximo(Catalogo catalogo, Scanner scanner) {
        boolean regresar = false;
        while (!regresar) {
            System.out.print("Ingresa el costo maximo: (0 para regresar) ");
            double costoMaximo = scanner.nextDouble();
            scanner.nextLine();

            if (costoMaximo == 0) {
                regresar = true;
                continue;
            }
            System.out.println();
            catalogo.filtrarPorCostoMaximo(costoMaximo);
            System.out.println();
        }
    }

    /**
     * Muestra el menu para filtrar por genero.
     * 
     * @param catalogo El catalogo de productos.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private void menuPorGenero(Catalogo catalogo, Scanner scanner) {
        boolean regresar = false;
        while (!regresar) {
            System.out.println();
            System.out.println("Generos disponibles:");
            System.out.println("1. Aventura");
            System.out.println("2. Ciencia Ficcion");
            System.out.println("3. Fantasia");
            System.out.println("4. Animada");
            System.out.println("5. K-pop");
            System.out.println("6. Regional Mexicano");
            System.out.println("7. Balada");
            System.out.println("0. Regresar al menu principal");
            System.out.print("Selecciona una opcion: ");
            int generoOpcion = scanner.nextInt();
            scanner.nextLine();

            if (generoOpcion == 0) {
                regresar = true;
                continue;
            }
            Genero genero = null;
            switch (generoOpcion) {
                case 1:
                    genero = GeneroPelicula.AVENTURA;
                    break;
                case 2:
                    genero = GeneroPelicula.CIENCIA_FICCION;
                    break;
                case 3:
                    genero = GeneroPelicula.FANTASIA;
                    break;
                case 4:
                    genero = GeneroPelicula.ANIMADA;
                    break;
                case 5:
                    genero = GeneroMusical.KPOP;
                    break;
                case 6:
                    genero = GeneroMusical.REGIONAL_MEXICANO;
                    break;
                case 7:
                    genero = GeneroMusical.BALADA;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    continue;
            }
            if (genero != null) {
                System.out.println();
                catalogo.filtrarPorGenero(genero);
                System.out.println();
            }
        }
    }
}
