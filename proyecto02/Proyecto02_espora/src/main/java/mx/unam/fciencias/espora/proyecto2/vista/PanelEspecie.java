package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane; // Usamos FlowPane para las tarjetas
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import mx.unam.fciencias.espora.proyecto2.modelo.*;

public class PanelEspecie extends VBox implements Observer {

    private EcosistemaInterfaz ecosistema;
    private ZonaEcosistema zonaObjetivo;
    private FlowPane contenedorTarjetas;

    /**
     * Construye el panel que muestra las especies y se registra como observador.
     * @param ecosistema Interfaz del modelo usada para leer datos.
     */
    public PanelEspecie(EcosistemaInterfaz ecosistema) {
        this.ecosistema = ecosistema;
        this.ecosistema.registrarObservador(this);
        inicializarComponentes();
    }

    /**
     * Establece la zona objetivo cuyas especies se mostraran.
     * @param zona Zona a mostrar.
     */
    public void setZonaObjetivo(ZonaEcosistema zona) {
        this.zonaObjetivo = zona;
        actualizar();
    }

    private void inicializarComponentes() {
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        
        Label titulo = new Label("Estado de las Especies");
        titulo.getStyleClass().add("subtitulo-seccion");
        
        contenedorTarjetas = new FlowPane();
        contenedorTarjetas.setHgap(20);
        contenedorTarjetas.setVgap(20);
        contenedorTarjetas.setPrefWrapLength(600);

        ScrollPane scroll = new ScrollPane(contenedorTarjetas);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scroll.setPannable(true);
        
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

    private ImageView cargarImagen(String nombre) {
        String nombreArchivo = nombre.toLowerCase().replace(" ", "_") + ".jpg";
        String ruta = "/imagenes/" + nombreArchivo;
        try {
            var url = getClass().getResource(ruta);
            if (url != null) {
                return new ImageView(new javafx.scene.image.Image(url.toExternalForm()));
            }
        } catch (Exception e) { }
        return new ImageView();
    }

    private void crearTarjetaEspecie(PoblacionEspecie p) {
        VBox tarjeta = new VBox(10);
        tarjeta.getStyleClass().add("tarjeta-especie"); 

        ImageView foto = cargarImagen(p.getNombre());
        foto.setFitHeight(140);
        foto.setFitWidth(250);
        foto.setPreserveRatio(true);
        
        HBox cajaFoto = new HBox(foto);
        cajaFoto.setAlignment(Pos.CENTER);
        cajaFoto.setStyle("-fx-background-color: #f8f9fa; -fx-background-radius: 10;");
        cajaFoto.setPadding(new Insets(5));

        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        
        Label lblNombre = new Label(p.getNombre());
        lblNombre.getStyleClass().add("nombre-especie");
        
        javafx.scene.layout.Region spacer = new javafx.scene.layout.Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Label badgeEstado = new Label(p.getEstado());
        badgeEstado.getStyleClass().add(obtenerClaseEstado(p.getEstado()));
        
        encabezado.getChildren().addAll(lblNombre, spacer, badgeEstado);

        Label lblPoblacionTitulo = new Label("Población Actual");
        lblPoblacionTitulo.setStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 12px;");
        
        Label lblNumero = new Label(String.valueOf(p.getTamanio()) + " ejemplares");
        lblNumero.getStyleClass().add("dato-poblacion");

        tarjeta.getChildren().addAll(cajaFoto, encabezado, lblPoblacionTitulo, lblNumero);
        
        contenedorTarjetas.getChildren().add(tarjeta);
    }

    private String obtenerClaseEstado(String estado) {
        if ("Crítico".equalsIgnoreCase(estado)) return "badge-critico";
        if ("En Riesgo".equalsIgnoreCase(estado)) return "badge-riesgo";
        return "badge-saludable";
    }
}