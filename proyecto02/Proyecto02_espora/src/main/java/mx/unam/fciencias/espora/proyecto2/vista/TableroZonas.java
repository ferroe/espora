package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControladorInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ComponenteEcosistema;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;
import java.util.List;

public class TableroZonas extends BorderPane {

    private SimuladorControladorInterfaz controlador;
    private EcosistemaInterfaz ecosistema;
    private GridPane gridZonas;

    public TableroZonas(SimuladorControladorInterfaz controlador, EcosistemaInterfaz ecosistema) {
        this.controlador = controlador;
        this.ecosistema = ecosistema;
        
        // Cargar CSS
        this.getStylesheets().add(getClass().getResource("/estilos/tablero.css").toExternalForm());

        inicializarUI();
        cargarZonasDelModelo();
    }

    private void inicializarUI() {
        // --- ENCABEZADO ---
        VBox header = new VBox(5);
        header.setPadding(new Insets(30, 40, 20, 40));
        
        Label titulo = new Label("Selecciona una Zona de Xochimilco");
        titulo.getStyleClass().add("header-titulo");
        
        Label subtitulo = new Label("Elige una zona para monitorear su ecosistema y gestionar las especies nativas");
        subtitulo.getStyleClass().add("header-subtitulo");
        
        header.getChildren().addAll(titulo, subtitulo);
        this.setTop(header);

        // --- CONTENIDO CENTRAL (GRID) ---
        gridZonas = new GridPane();
        gridZonas.setHgap(50);
        gridZonas.setVgap(50);
        gridZonas.setPadding(new Insets(40)); // Más margen alrededor
        gridZonas.setAlignment(Pos.CENTER);

        // Scroll por si hay muchas zonas en el futuro
        ScrollPane scroll = new ScrollPane(gridZonas);
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true); // ¡Importante para centrar verticalmente!
        scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        
        this.setCenter(scroll);
    }

    private void cargarZonasDelModelo() {
        List<ComponenteEcosistema> zonas = ecosistema.getXochimilcoRaiz().getComponentes();
        int col = 0;
        int row = 0;

        for (ComponenteEcosistema comp : zonas) {
            if (comp instanceof ZonaEcosistema) {
                ZonaEcosistema zona = (ZonaEcosistema) comp;
                VBox tarjeta = crearTarjetaZona(zona);
                
                gridZonas.add(tarjeta, col, row);
                
                col++;
                if (col == 2) { // 2 columnas como en tu imagen
                    col = 0;
                    row++;
                }
            }
        }
    }

    private VBox crearTarjetaZona(ZonaEcosistema zona) {
        VBox tarjeta = new VBox(15);
        tarjeta.getStyleClass().add("tarjeta-zona");
        tarjeta.setAlignment(Pos.TOP_CENTER);
        // --- 1. IMAGEN DE LA ZONA (NUEVO) ---
        // Usamos un StackPane para recortar la imagen con bordes redondeados si quieres
        ImageView imagenZona = cargarImagen(zona.getNombre());
        imagenZona.setFitHeight(120); // Altura fija
        imagenZona.setFitWidth(280);  // Ancho fijo (ajusta según tu CSS)
        imagenZona.setPreserveRatio(false); // Llenar todo el espacio
        
        // Clip para bordes redondeados (opcional, estilo moderno)
        javafx.scene.shape.Rectangle clip = new javafx.scene.shape.Rectangle(280, 120);
        clip.setArcWidth(12);
        clip.setArcHeight(12);
        imagenZona.setClip(clip);

        // --- 2. Encabezado (Nombre + Badge) ---
        HBox encabezado = new HBox(10);
        encabezado.setAlignment(Pos.CENTER_LEFT);
        
        Label lblNombre = new Label(zona.getNombre());
        lblNombre.getStyleClass().add("zona-titulo");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Label lblBadge = new Label(zona.getEstado());
        lblBadge.getStyleClass().addAll("badge-base", obtenerClaseBadge(zona.getEstado()));
        
        encabezado.getChildren().addAll(lblNombre, spacer, lblBadge);

        // 2. Datos (Población Total)
        HBox datosBox = new HBox();
        datosBox.setAlignment(Pos.CENTER_LEFT);
        Label lblTituloPob = new Label("Población Total");
        lblTituloPob.getStyleClass().add("zona-dato-label");
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        Label lblValorPob = new Label(String.valueOf(zona.getTamanio())); // Número real
        lblValorPob.getStyleClass().add("zona-dato-valor");
        datosBox.getChildren().addAll(lblTituloPob, spacer2, lblValorPob);

        // 3. Barra de Progreso (Decorativa basada en estado)
        StackPane barraProgreso = new StackPane();
        barraProgreso.setAlignment(Pos.CENTER_LEFT);
        
        Rectangle fondoBarra = new Rectangle(300, 6); // Ancho fijo relativo
        fondoBarra.getStyleClass().add("barra-fondo");
        fondoBarra.widthProperty().bind(tarjeta.widthProperty().subtract(50)); // Dinámico
        
        Rectangle rellenoBarra = new Rectangle();
        rellenoBarra.heightProperty().bind(fondoBarra.heightProperty());
        rellenoBarra.widthProperty().bind(fondoBarra.widthProperty().multiply(calcularPorcentajeSalud(zona))); 
        rellenoBarra.getStyleClass().add(obtenerClaseBarra(zona.getEstado()));
        
        barraProgreso.getChildren().addAll(fondoBarra, rellenoBarra);

        // 4. Footer (Link)
        Label lblLink = new Label("Click para ver detalles →");
        lblLink.getStyleClass().add("zona-link");
        HBox footer = new HBox(lblLink);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10, 0, 0, 0));

        // Armar tarjeta
        tarjeta.getChildren().addAll(imagenZona, encabezado, datosBox, barraProgreso, footer);

        tarjeta.setOnMouseClicked(e -> controlador.solicitarNavegacionADetalle(zona.getNombre()));

        return tarjeta;
    }

    // --- MÉTODO HELPER PARA CARGAR IMÁGENES ---
    private ImageView cargarImagen(String nombre) {
        // Convertir "Zona Norte" a "zona_norte.png"
        String nombreArchivo = nombre.toLowerCase().replace(" ", "_") + ".jpg";
        String ruta = "/imagenes/" + nombreArchivo;
        
        try {
            // Intentar cargar
            var url = getClass().getResource(ruta);
            if (url != null) {
                return new ImageView(new javafx.scene.image.Image(url.toExternalForm()));
            }
        } catch (Exception e) {
            System.err.println("No se encontró imagen: " + ruta);
        }

        ImageView placeholder = new ImageView();
        return placeholder;
    }

    // --- Helpers de Estilo ---

    private String obtenerClaseBadge(String estado) {
        if ("Crítico".equalsIgnoreCase(estado)) return "badge-critico";
        if ("En Riesgo".equalsIgnoreCase(estado)) return "badge-riesgo";
        return "badge-saludable";
    }

    private String obtenerClaseBarra(String estado) {
        if ("Crítico".equalsIgnoreCase(estado)) return "barra-progreso-critico";
        if ("En Riesgo".equalsIgnoreCase(estado)) return "barra-progreso-riesgo";
        return "barra-progreso-saludable";
    }

    private double calcularPorcentajeSalud(ZonaEcosistema zona) {
        // Lógica simple para la barra: Saludable=100%, Riesgo=60%, Crítico=30%
        // O podrías usar zona.getSalud() si devuelve un double entre 0 y 1.
        String estado = zona.getEstado();
        if ("Crítico".equalsIgnoreCase(estado)) return 0.3;
        if ("En Riesgo".equalsIgnoreCase(estado)) return 0.6;
        return 1.0;
    }
}