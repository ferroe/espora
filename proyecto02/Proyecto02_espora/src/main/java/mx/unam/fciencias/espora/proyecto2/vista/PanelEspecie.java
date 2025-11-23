package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane; // Usamos FlowPane para las tarjetas
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import mx.unam.fciencias.espora.proyecto2.modelo.*;

public class PanelEspecie extends VBox implements Observer {

    private EcosistemaInterfaz ecosistema;
    private ZonaEcosistema zonaObjetivo;
    private FlowPane contenedorTarjetas; // Cambio clave: FlowPane

    public PanelEspecie(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
        inicializarComponentes();
    }

    public void setZonaObjetivo(ZonaEcosistema zona) {
        this.zonaObjetivo = zona;
        actualizar();
    }

    private void inicializarComponentes() {
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        
        // Título de la sección
        Label titulo = new Label("Estado de las Especies");
        titulo.getStyleClass().add("subtitulo-seccion"); // Clase CSS
        
        // Contenedor de tarjetas (FlowPane permite que se acomoden en filas)
        contenedorTarjetas = new FlowPane();
        contenedorTarjetas.setHgap(20); // Espacio horizontal entre tarjetas
        contenedorTarjetas.setVgap(20); // Espacio vertical
        contenedorTarjetas.setPrefWrapLength(600); // Ancho preferido antes de bajar de línea

        // ScrollPane transparente
        ScrollPane scroll = new ScrollPane(contenedorTarjetas);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scroll.setPannable(true);
        
        // Hacemos que el scroll crezca
        VBox.setVgrow(scroll, Priority.ALWAYS);
        
        this.getChildren().addAll(titulo, scroll);
    }
    
    @Override
    public void actualizar() {
        contenedorTarjetas.getChildren().clear();
        if (zonaObjetivo == null) return;

        for (ComponenteEcosistema hijo : zonaObjetivo.getComponentes()) {
            if (hijo instanceof PoblacionEspecie) {
                crearTarjetaEspecie((PoblacionEspecie) hijo);
            }
        }
    }

    private void crearTarjetaEspecie(PoblacionEspecie p) {
        VBox tarjeta = new VBox(10);
        tarjeta.getStyleClass().add("tarjeta-especie"); // CSS

        // 1. Encabezado (Nombre + Badge Estado)
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        
        Label lblNombre = new Label(p.getNombre());
        lblNombre.getStyleClass().add("nombre-especie");
        
        // Espaciador para empujar el badge a la derecha
        javafx.scene.layout.Region spacer = new javafx.scene.layout.Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Label badgeEstado = new Label(p.getEstado());
        badgeEstado.getStyleClass().add(obtenerClaseEstado(p.getEstado())); // Clase dinámica
        
        encabezado.getChildren().addAll(lblNombre, spacer, badgeEstado);

        // 2. Imagen (Placeholder - Puedes agregar un ImageView aquí si tienes fotos)
        // ImageView imgView = new ImageView(new Image("ruta/a/imagen.png"));
        // imgView.setFitHeight(100); imgView.setPreserveRatio(true);
        
        // 3. Datos de Población (Número grande)
        Label lblPoblacionTitulo = new Label("Población Total");
        lblPoblacionTitulo.setStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 12px;");
        
        Label lblNumero = new Label(String.valueOf(p.getTamanio()));
        lblNumero.getStyleClass().add("dato-poblacion");

        // 4. Barra de progreso (simulada con CSS o ProgressBar real)
        // Por ahora solo el número como pediste.

        tarjeta.getChildren().addAll(encabezado, lblPoblacionTitulo, lblNumero);
        
        contenedorTarjetas.getChildren().add(tarjeta);
    }

    private String obtenerClaseEstado(String estado) {
        if ("Crítico".equalsIgnoreCase(estado)) return "badge-critico";
        if ("En Riesgo".equalsIgnoreCase(estado)) return "badge-riesgo";
        return "badge-saludable";
    }
}