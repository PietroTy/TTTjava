package br.edu.ifsp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Velha {

    @FXML
    private void voltarEscolha() throws IOException {

        App.setRoot("escolhaTime" );

    }

    int[][] jogo = new int[3][3];

    public void checarVitoria(int[][] jogo){
        for(int i = 0; i < 3; i++){

            //Checa linha
            if((jogo[i][0] == 1) && (jogo[i][1] == 1) && (jogo[i][2] == 1)){
                System.out.println("Bola ganha linha");
            }

            //Checa linha
            if((jogo[0][i] == 1) && (jogo[1][i] == 1) && (jogo[2][i] == 1)){
                System.out.println("Bola ganha coluna");
            }

        }

        if( ( jogo[0][0] == 1) && ( jogo[1][1] == 1 ) && jogo[2][2] == 1 ) {

            System.out.println( "Bola ganha diagonal principal" );

        } 

        if( ( jogo[0][2] == 1) && ( jogo[1][1] == 1 ) && jogo[2][0] == 1 ) {

            System.out.println( "Bola ganha diagonal secundaria" );

        }
    }

    public void computarJogada(Button botao){
         
    }
}
