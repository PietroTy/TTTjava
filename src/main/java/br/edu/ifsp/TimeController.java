package br.edu.ifsp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class TimeController {

    @FXML
    private void irMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    private TextField nomeX;
    @FXML
    private TextField nomeO;

    String nomeXis;
    String nomeBola;

    public void inserirNomeX( ActionEvent event ) {

        nomeXis = nomeX.getText();

    }

    public void inserirNomeO( ActionEvent event ) {

        nomeBola = nomeO.getText();

    }
}