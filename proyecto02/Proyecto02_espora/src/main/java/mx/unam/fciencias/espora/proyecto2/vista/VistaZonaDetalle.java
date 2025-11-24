package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControladorInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.Observer;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;

/**
 *
 * Vista que muestra el detalle de una zona: lista de especies y
 * panel de control con acciones sobre la zona.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class VistaZonaDetalle extends BorderPane implements Observer {

    private SimuladorControladorInterfaz controlador;
    private EcosistemaInterfaz ecosistema;
    private Label lblNombreZona;
    private PanelEspecie panelEspecies;
    private Label lblNivelContaminacion;
    private Label lblNivelInvasoras;
    private String nombreZonaActual;

    /**
     * Constructor de la vista de detalle de zona.
     * @param controlador
     * @param ecosistema
     */
    public VistaZonaDetalle(SimuladorControladorInterfaz controlador, EcosistemaInterfaz ecosistema) {
        this.controlador = controlador;
        this.ecosistema = ecosistema;

        this.ecosistema.registrarObservador(this);
        
        this.getStylesheets().add(getClass().getResource("/estilos/detalle.css").toExternalForm());

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes de la vista.
     */
    private void inicializarComponentes() {
        VBox topBox = new VBox(15);
        topBox.setPadding(new Insets(20, 30, 10, 30));
        
        Button btnVolver = new Button("← Volver");
        btnVolver.getStyleClass().add("boton-volver");
        btnVolver.setOnAction(e -> controlador.solicitarNavegacionATablero());
        
        lblNombreZona = new Label("Cargando...");
        lblNombreZona.getStyleClass().add("titulo-zona");
        
        topBox.getChildren().addAll(btnVolver, lblNombreZona);
        this.setTop(topBox);

        panelEspecies = new PanelEspecie(ecosistema);
        this.setCenter(panelEspecies);

        crearPanelLateral();
    }

    /**
     * Crea el panel lateral con los botones de acción.
     */
    private void crearPanelLateral() {
        VBox panelLateral = new VBox(15);
        panelLateral.getStyleClass().add("panel-lateral");
        panelLateral.setPrefWidth(300);
        
        BorderPane.setMargin(panelLateral, new Insets(10, 30, 30, 10));

        Label lblTitulo = new Label("Panel de Control");
        lblTitulo.getStyleClass().add("subtitulo-seccion");
        lblNivelContaminacion = new Label("Contaminación: -");
        lblNivelInvasoras = new Label("Invasoras: -");

        Button btnBasura = crearBoton("Tirar Basura", "btn-rojo");
        btnBasura.setOnAction(e -> controlador.tirarBasura(lblNombreZona.getText()));

        Button btnTilapias = crearBoton("Introducir Tilapias", "btn-naranja");
        btnTilapias.setOnAction(e -> controlador.introducirTilapias(lblNombreZona.getText()));

        Button btnLimpiar = crearBoton("Limpiar Zona", "btn-azul");
        btnLimpiar.setOnAction(e -> controlador.limpiarZona(lblNombreZona.getText()));

        Button btnRepoblar = crearBoton("Repoblar Ajolotes", "btn-morado");
        btnRepoblar.setOnAction(e -> controlador.repoblarAjolotes(lblNombreZona.getText()));

        Button btnFlora = crearBoton("Restaurar Flora", "btn-verde");
        btnFlora.setOnAction(e -> controlador.restaurarFlora(lblNombreZona.getText()));

        panelLateral.getChildren().addAll(
            lblTitulo,
            lblNivelContaminacion,
            lblNivelInvasoras,
            btnBasura, btnTilapias,
            btnLimpiar, btnRepoblar, btnFlora
        );
        
        this.setRight(panelLateral);
    }

    /**
     * Crea un botón con el texto y clase CSS especificados.
     * @param texto Texto del botón.
     * @param claseCss Clase CSS para el botón.
     * @return Botón creado.
     */
    private Button crearBoton(String texto, String claseCss) {
        Button btn = new Button(texto);
        btn.getStyleClass().addAll("boton-accion", claseCss);
        btn.setMaxWidth(Double.MAX_VALUE);
        return btn;
    }

    /**
     * Carga los datos de la zona en la vista (nombre y especies).
     * @param nombreZona Nombre de la zona a cargar.
     */
    public void cargarDatosZona(String nombreZona) {
        this.nombreZonaActual = nombreZona;
        this.lblNombreZona.setText(nombreZona);
        
        actualizarEtiquetas();
        
        ZonaEcosistema zona = ecosistema.buscarZona(nombreZona);
        if (zona != null) {
            panelEspecies.setZonaObjetivo(zona);
        }
    }

    /**
     * Actualiza la vista cuando el modelo cambia.
     */
    @Override
    public void actualizar() {
        // Cada vez que el modelo cambia, refrescamos los números
        if (nombreZonaActual != null) {
            actualizarEtiquetas();
        }
    }

    /**
     * Actualiza las etiquetas de contaminación e invasoras.
     */
    private void actualizarEtiquetas() {
        ZonaEcosistema zona = ecosistema.buscarZona(nombreZonaActual);
        if (zona != null) {
            double cont = zona.getParametros().getNivelContaminacion();
            double inv = zona.getParametros().getNivelEspeciesInvasoras();

            javafx.application.Platform.runLater(() -> {
                lblNivelContaminacion.setText(String.format("Contaminación: %.0f%%", cont * 100));
                lblNivelInvasoras.setText(String.format("Invasoras: %.0f%%", inv * 100));
            });
        }
    }
}