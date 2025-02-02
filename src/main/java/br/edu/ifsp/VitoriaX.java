package br.edu.ifsp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.layout.Pane;
import javafx.beans.binding.Bindings;

public class VitoriaX implements Initializable {

    @FXML
    private Pane paneX;

    @FXML
    private Text caixaDeTexto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        caixaDeTexto.setText(TimeController.nomeXis);
       
    }

      @FXML
    private void voltarMenuX() throws IOException {

        App.setRoot("menu");

    }

}
