package br.edu.ifsp;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void irEscolha() throws IOException {
        App.setRoot("escolhaTime");
    }

    @FXML
    private void sair() throws IOException {
        System.exit(0);
    }
}
