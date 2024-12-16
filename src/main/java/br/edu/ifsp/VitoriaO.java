package br.edu.ifsp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class VitoriaO implements Initializable {
    @FXML
    private Text caixaDeTexto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caixaDeTexto.setText(TimeController.nomeBola);
    }


}