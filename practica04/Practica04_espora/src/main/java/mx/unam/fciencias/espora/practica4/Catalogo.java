package mx.unam.fciencias.espora.practica4;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Catalogo.
 * 
 * Representa el catalogo de productos de RockBuster.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Catalogo {

    private List<ProductoCatalogo> catalogo = new ArrayList<>();

    /**
     * Agrega un producto al catalogo.
     * 
     * @param producto El producto a agregar.
     */
    public void agregarProducto(ProductoCatalogo producto) {
        this.catalogo.add(producto);
    }

    public ProductoCatalogo getProducto(int indice) {
        if (indice < 1 && indice > catalogo.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return catalogo.get(indice - 1);
    }

    /**
     * Muestra el catalogo completo.
     */
    public void verCatalogoCompleto() {
        System.out.println("--- Catalogo Completo ---");
        if (catalogo.isEmpty()) {
            System.out.println("No hay productos en el catalogo");
            return;
        }
        int indice = 1;
        for (ProductoCatalogo producto : catalogo) {
            System.out.printf(
                "%d. %s - $%.2f\n", indice, producto.getNombre(), producto.getPrecio());
            indice++;
        }
    }

    /**
     * Filtra el catalogo por costo maximo.
     * 
     * @param costoMaximo El costo maximo a filtrar.
     */
    public void filtrarPorCostoMaximo(double costoMaximo) {
        System.out.println("--- Catalogo por costo maximo ---");
        if (catalogo.isEmpty()) {
            System.out.println("No hay productos en el catalogo");
            return;
        }
        int indice = 1;
        boolean encontrado = false;
        for (ProductoCatalogo producto : catalogo) {
            if (producto.getPrecio() <= costoMaximo) {
                System.out.printf(
                    "%d. %s - $%.2f\n", indice, producto.getNombre(), producto.getPrecio());
                indice++;
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos por debajo de ese precio");
        }
    }

    /**
     * Filtra el catalogo por genero.
     * 
     * @param genero El genero a filtrar.
     */
    public void filtrarPorGenero(Genero genero) {
        System.out.println("--- Catalogo por genero ---");
        int indice = 1;
        boolean encontrado = false;
        for (ProductoCatalogo producto : catalogo) {
            if (producto.getGenero() == genero) {
                System.out.printf(
                    "%d. %s - $%.2f\n", indice, producto.getNombre(), producto.getPrecio());
                indice++;
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos de ese genero");
        }
    }
}