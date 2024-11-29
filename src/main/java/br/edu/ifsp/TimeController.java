package br.edu.ifsp;

import java.io.IOException;
import javafx.fxml.FXML;

public class TimeController {

    @FXML
    private void irMenu() throws IOException {
        App.setRoot("menu");
    }
}