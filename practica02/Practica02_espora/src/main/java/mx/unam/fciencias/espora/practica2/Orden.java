package mx.unam.fciencias.espora.practica2;

import java.util.ArrayList;
import java.util.List;

public class Orden {

    private List<Producto> productos;

    public Orden() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto instanceof Pizza) {
            for (Producto p : productos) {
                if (p instanceof Pizza) {
                    System.out.println("Solo puedes ordenar una pizza por orden.");
                    return;
                }
            }
        }
        if (producto instanceof Helado) {
            for (Producto p : productos) {
                if (p instanceof Helado) {
                    System.out.println("Solo puedes ordenar un helado por orden.");
                    return;
                }
            }
        }
        this.productos.add(producto);
    }

    /**
     * Este metodo devuelve la lista de productos de la orden
     * @return Lista de productos
     */
    public List<Producto> getProductos() {
        return this.productos;
    }

    /**
     * Este metodo verifica si la orden está vacía
     * @return true si no hay productos, false en caso contrario
     */
    public boolean isVacia() {
        return this.productos.isEmpty();
    }

    /**
     * Este metodo genera y devuelve una representación en String del ticket final
     * @return El ticket
     */
    public String generarTicket() {
        StringBuilder ticket = new StringBuilder();
        double total = 0;

        ticket.append("--- TICKET PEQUEÑO CESARÍN ---\n");
        for (Producto producto : productos) {
            // Llama a los métodos de la interfaz Producto
            ticket.append(String.format("%-30s $%7.2f\n", producto.getInfoTicket(), producto.costo()));
            total += producto.costo();
        }
        ticket.append("------------------------------------\n");
        ticket.append(String.format("%-30s $%7.2f\n", "TOTAL:", total));
        ticket.append("------------------------------------\n");
        ticket.append("¡Gracias por su compra!\n");

        return ticket.toString();
    }
}