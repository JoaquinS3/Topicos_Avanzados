package com.example.primeapp.views;

import com.example.primeapp.events.EventoLoteria;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Loteria extends Stage implements EventHandler {

    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente, btnJugar;
    private Label lblTiempo;
    private GridPane gdpPlantilla;
    private Image imgCarta;
    private Scene escena;
    private File file;

    private String[] arImagenes ={"barril.jpeg","botella.jpeg","catrin.jpeg","chavorruco.jpeg",
            "concha.jpeg","graduada.jpeg","luchador.jpeg","maceta.jpeg","rosa.jpeg","tacos.jpeg",
            "venado.jpeg"};
    private Button[][] arBtnPlantilla=new Button[4][2];
    private Image imgCardP;
    private ImageView imv;

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAtras = new Button( "Atras");
        btnAtras.setPrefWidth(100);
        btnAtras.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoLoteria());
        btnSiguiente = new Button("Siguiente");

       // @Override
       // public void handle(Event event) {
       //     System.out.println("Mi primer evento Fovifest desde otra clase");
       // }


        btnSiguiente.setPrefWidth(100);
        lblTiempo = new Label("00:00");
        hBox1 = new HBox();
        hBox1.setSpacing(35);
        hBox1.getChildren().addAll(btnAtras,btnSiguiente,lblTiempo);


        gdpPlantilla = new GridPane();
        CrarPlantilla();
        //imgCarta=new Image();

        hBox2 =new HBox();
        hBox2.setSpacing(5);
        hBox2.getChildren().addAll(gdpPlantilla);

        btnJugar =new Button("Jugar");
        btnJugar.setPrefWidth(250);
        btnJugar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);

        vBox =new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox1,hBox2,btnJugar);

        escena = new Scene(vBox,350,400);


    }

    private void CrarPlantilla(){
        for (int i =0; i<2; i++){
            for (int j =0; j<4; j++){
                arBtnPlantilla[j][i]=new Button();
                file = new File("src/main/java/com/example/primeapp/Imagenes/barril.jpeg"   );
                imgCarta = new Image(file.toURI().toString());
                ImageView imv = new ImageView(imgCarta);
                imv.setFitWidth(50);
                imv.setFitHeight(70);
                arBtnPlantilla[j][i].setGraphic(imv);
                gdpPlantilla.add(arBtnPlantilla[j][i],i,j);
            }
        }
    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento Fovifest :");

    }
}
