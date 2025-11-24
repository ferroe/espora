package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControladorInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;

/**
 *
 * Vista que muestra el detalle de una zona: lista de especies y
 * panel de control con acciones sobre la zona.
 *
 */
public class VistaZonaDetalle extends BorderPane {

    private SimuladorControladorInterfaz controlador;
    private EcosistemaInterfaz ecosistema;
    private Label lblNombreZona;
    private PanelEspecie panelEspecies;

    public VistaZonaDetalle(SimuladorControladorInterfaz controlador, EcosistemaInterfaz ecosistema) {
        this.controlador = controlador;
        this.ecosistema = ecosistema;
        
        this.getStylesheets().add(getClass().getResource("/estilos/detalle.css").toExternalForm());

        inicializarComponentes();
    }

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

    private void crearPanelLateral() {
        VBox panelLateral = new VBox(15);
        panelLateral.getStyleClass().add("panel-lateral");
        panelLateral.setPrefWidth(300);
        
        BorderPane.setMargin(panelLateral, new Insets(10, 30, 30, 10));

        Label lblTitulo = new Label("Panel de Control");
        lblTitulo.getStyleClass().add("subtitulo-seccion");

        Button btnBasura = crearBoton("🗑️ Tirar Basura", "btn-rojo");
        btnBasura.setOnAction(e -> controlador.tirarBasura(lblNombreZona.getText()));

        Button btnTilapias = crearBoton("🐟 Introducir Tilapias", "btn-naranja");
        btnTilapias.setOnAction(e -> controlador.introducirTilapias(lblNombreZona.getText()));

        Button btnLimpiar = crearBoton("✨ Limpiar Zona", "btn-azul");
        btnLimpiar.setOnAction(e -> controlador.limpiarZona(lblNombreZona.getText()));

        Button btnRepoblar = crearBoton("❤️ Repoblar Ajolotes", "btn-morado");
        btnRepoblar.setOnAction(e -> controlador.repoblarAjolotes(lblNombreZona.getText()));

        Button btnFlora = crearBoton("🌿 Restaurar Flora", "btn-verde");
        btnFlora.setOnAction(e -> controlador.restaurarFlora(lblNombreZona.getText()));

        panelLateral.getChildren().addAll(
            lblTitulo, 
            btnBasura, btnTilapias,
            btnLimpiar, btnRepoblar, btnFlora
        );
        
        this.setRight(panelLateral);
    }

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
        this.lblNombreZona.setText(nombreZona);
        ZonaEcosistema zona = ecosistema.buscarZona(nombreZona);
        if (zona != null) {
            panelEspecies.setZonaObjetivo(zona);
        }
    }
}