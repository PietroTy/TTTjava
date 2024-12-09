package br.edu.ifsp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Velha {

    @FXML
    private void voltarEscolha() throws IOException {

        App.setRoot("escolhaTime" );

    }

    @FXML
    private Button b00;
    @FXML
    private Button b01;
    @FXML
    private Button b02;
    @FXML
    private Button b10;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b20;
    @FXML
    private Button b21;
    @FXML
    private Button b22;

    //Array de 3 por 3 para representar o tabuleiro do jogo;
    int[][] jogo = new int[3][3];
    private int PLAYER_X = 1;
    private int PLAYER_O = 2;
    boolean turno = true;          //true é X ; false é O;
    public Canvas canvas = new Canvas(800, 500);
    public GraphicsContext gc = canvas.getGraphicsContext2D();
    public StackPane root = new StackPane();


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

            b00.setText("X");
            b00.setOpacity(1);

            System.out.println(jogo[0][0]);

        } else {

            jogo[0][0] = 2;
            turno =! turno;
        }

        b00.setDisable( true );

    }
    public void computarJogada01(){

        if( turno ) {

            jogo[0][1] = 1;
            turno =! turno;

        } else {

            jogo[0][1] = 2;
            turno =! turno;
        }
        
        b01.setDisable( true );

    }
    public void computarJogada02(){

        if( turno ) {

            jogo[0][2] = 1;
            turno =! turno;

        } else {

            jogo[0][2] = 2;
            turno =! turno;
        }

        b02.setDisable( true );

    }
    public void computarJogada10(){

        if( turno ) {

            jogo[1][0] = 1;
            turno =! turno;

        } else {

            jogo[1][0] = 2;
            turno =! turno;
        }

        b10.setDisable( true );

    }
    public void computarJogada11(){

        if( turno ) {

            jogo[1][1] = 1;
            turno =! turno;

        } else {

            jogo[1][1] = 2;
            turno =! turno;
        }

        b11.setDisable( true );

    }
    public void computarJogada12(){

        if( turno ) {

            jogo[1][2] = 1;
            turno =! turno;

        } else {

            jogo[1][2] = 2;
            turno =! turno;
        }

        b12.setDisable( true );

    }
    public void computarJogada20(){

        if( turno ) {

            jogo[2][0] = 1;
            turno =! turno;

        } else {

            jogo[2][0] = 2;
            turno =! turno;
        }

        b20.setDisable( true );

    }
    public void computarJogada21(){

        if( turno ) {

            jogo[2][1] = 1;
            turno =! turno;

        } else {

            jogo[2][1] = 2;
            turno =! turno;
        }

        b21.setDisable( true );

    }
    public void computarJogada22(){

        if( turno ) {

            jogo[2][2] = 1;
            turno =! turno;

        } else {

            jogo[2][2] = 2;
            turno =! turno;
        }

        b22.setDisable( true );

    }


}
