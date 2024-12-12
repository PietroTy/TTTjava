package br.edu.ifsp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class VitoriaX {

    @FXML
    public Text caixaDeTexto;

    public void modificarTexto(Text caixa, String texto){
        caixa.setText(texto);
    }

}
