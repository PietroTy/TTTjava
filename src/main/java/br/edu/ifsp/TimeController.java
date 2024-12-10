package br.edu.ifsp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class TimeController {

    @FXML
    private void irMenu() throws IOException {

        App.setRoot("menu" );

    }

    @FXML
    private void irVelha() throws IOException {

        App.setRoot("velha" );

    }

    @FXML
    private void irVelhaQuadrado() throws IOException {

        App.setRoot( "velha2" );

    }

    @FXML
    private TextField nomeX;
    @FXML
    private TextField nomeO;

    public String nomeXis;
    public String nomeBola;

    @FXML
    private void guardarX() {

        nomeXis = nomeX.getText();

    }

    @FXML
    private void guardarO() {

        nomeBola = nomeO.getText();

    }

}