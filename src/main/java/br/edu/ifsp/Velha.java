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
    boolean turno = true;          //true é X ; false é O;

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

    public void computarJogada00(){

        if( turno ) {

            jogo[0][0] = 1;
            turno =! turno;

        } else {

            jogo[0][0] = 2;
            turno =! turno;
        }

    }
    public void computarJogada01(){

        if( turno ) {

            jogo[0][1] = 1;
            turno =! turno;

        } else {

            jogo[0][1] = 2;
            turno =! turno;
        }
        
    }
    public void computarJogada02(){

        if( turno ) {

            jogo[0][2] = 1;
            turno =! turno;

        } else {

            jogo[0][2] = 2;
            turno =! turno;
        }

    }
    public void computarJogada10(){

        if( turno ) {

            jogo[1][0] = 1;
            turno =! turno;

        } else {

            jogo[1][0] = 2;
            turno =! turno;
        }

    }
    public void computarJogada11(){

        if( turno ) {

            jogo[1][1] = 1;
            turno =! turno;

        } else {

            jogo[1][1] = 2;
            turno =! turno;
        }

    }
    public void computarJogada12(){

        if( turno ) {

            jogo[1][2] = 1;
            turno =! turno;

        } else {

            jogo[1][2] = 2;
            turno =! turno;
        }


    }
    public void computarJogada20(){

        if( turno ) {

            jogo[2][0] = 1;
            turno =! turno;

        } else {

            jogo[2][0] = 2;
            turno =! turno;
        }


    }
    public void computarJogada21(){

        if( turno ) {

            jogo[2][1] = 1;
            turno =! turno;

        } else {

            jogo[2][1] = 2;
            turno =! turno;
        }


    }
    public void computarJogada22(){

        if( turno ) {

            jogo[2][2] = 1;
            turno =! turno;

        } else {

            jogo[2][2] = 2;
            turno =! turno;
        }

        System.out.printf("%d\n", jogo[2][2]);

    }

}
