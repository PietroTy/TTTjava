package br.edu.ifsp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Velha {

    @FXML
    private void voltarEscolha() throws IOException {

        App.setRoot("escolhaTime" );

    }

    //Array de 3 por 3 para representar o tabuleiro do jogo;
    int[][] jogo = new int[3][3];
    private int PLAYER_X = 1;
    private int PLAYER_O = 2;
    public int linha = 0;
    public int coluna = 0;

    /* 
    Button buttons = new Button[][] {
            { (Button) loader.getNamespace().get("button00"), (Button) loader.getNamespace().get("button01"), (Button) loader.getNamespace().get("button02") },
            { (Button) loader.getNamespace().get("button10"), (Button) loader.getNamespace().get("button11"), (Button) loader.getNamespace().get("button12") },
            { (Button) loader.getNamespace().get("button20"), (Button) loader.getNamespace().get("button21"), (Button) loader.getNamespace().get("button22") }
    };
    */

    public void checarVitoria(int[][] jogo){
        for(int i = 0; i < 3; i++){

            //Checa linha
            if((jogo[i][0] == 1) && (jogo[i][1] == 1) && (jogo[i][2] == 1)){
                System.out.println("Bola ganha linha");
            }

            //Checa coluna
            if((jogo[0][i] == 1) && (jogo[1][i] == 1) && (jogo[2][i] == 1)){
                System.out.println("Bola ganha coluna");
            }

        }

        //Checa diagonal 1
        if( ( jogo[0][0] == 1) && ( jogo[1][1] == 1 ) && jogo[2][2] == 1 ) {

            System.out.println( "Bola ganha diagonal principal" );

        } 

        //Checa diagonal 2
        if( ( jogo[0][2] == 1) && ( jogo[1][1] == 1 ) && jogo[2][0] == 1 ) {

            System.out.println( "Bola ganha diagonal secundaria" );

        }
    }



    public void computarJogada(){
        System.out.println(linha, coluna);

    }

    public void setLinha0(){
        linha = 0;
    }
    public void setLinha1(){
        linha = 1;
    }
    public void setLinha2(){
        linha = 2;
    }

    public void setColuna0(){
        coluna = 0;
    }
    public void setColuna1(){
        coluna = 1;
    }
    public void setColuna2(){
        coluna = 2;
    }
    


}
