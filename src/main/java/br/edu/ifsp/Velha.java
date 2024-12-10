package br.edu.ifsp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


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
    private int[][] jogo = new int[3][3];
    private boolean turno = true;          //true é X ; false é O;

    public void verificarEmpate(int[][] jogo) throws IOException {

        boolean cheio = true;
    
        // Verifica se todas as posições no tabuleiro estão preenchidas (sem valores 0)
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (jogo[i][j] == 0) {

                    cheio = false;  // Encontrou um espaço vazio, então o tabuleiro não está cheio
                    break;

                }

            }

        }
    
        // Se o tabuleiro estiver cheio e ninguém venceu, é empate
        if (cheio) {

            App.setRoot("empate");  // Direciona para a tela de empate

        }
        
    }

    private void checarVitoria(int[][] jogo) {

        try{
            
        for(int i = 0; i < 3; i++){

            //Checa linha X
            if((jogo[i][0] == 1) && (jogo[i][1] == 1) && (jogo[i][2] == 1)){
                
                App.setRoot("vitoriaX" );

            }

            //Checa coluna X
            if((jogo[0][i] == 1) && (jogo[1][i] == 1) && (jogo[2][i] == 1)){

                App.setRoot("vitoriaX" );
            
            }

             //Checa linha O
             if((jogo[i][0] == 2) && (jogo[i][1] == 2) && (jogo[i][2] == 2)){

                App.setRoot("vitoriaO" );
            
            }

            //Checa coluna O
            if((jogo[0][i] == 2) && (jogo[1][i] == 2) && (jogo[2][i] == 2)){
                
                App.setRoot("vitoriaO" );
    
            }

        }

        //Checa diagonal 1 X
        if( ( jogo[0][0] == 1) && ( jogo[1][1] == 1 ) && jogo[2][2] == 1 ) {

            App.setRoot("vitoriaX" );

        } 

        //Checa diagonal 2 X
        if( ( jogo[0][2] == 1) && ( jogo[1][1] == 1 ) && jogo[2][0] == 1 ) {

            App.setRoot("vitoriaX" );

        }

        //Checa diagonal 1 O
        if( ( jogo[0][0] == 2) && ( jogo[1][1] == 2 ) && jogo[2][2] == 2 ) {

            App.setRoot("vitoriaO" );

        } 

        //Checa diagonal 2 O
        if( ( jogo[0][2] == 2) && ( jogo[1][1] == 2 ) && jogo[2][0] == 2 ) {

            App.setRoot("vitoriaO" );

        }

        verificarEmpate( jogo );

        } catch(IOException ex){

            System.err.println(ex.getMessage());

        }

    }

    public void computarJogada00() {

        aparecerBotao(b00, 0, 0);

    }
    
    public void computarJogada01() {

        aparecerBotao(b01, 0, 1);

    }

    public void computarJogada02() {

        aparecerBotao(b02, 0, 2);

    }

    public void computarJogada10() {

        aparecerBotao(b10, 1, 0);

    }
    
    public void computarJogada11() {

        aparecerBotao(b11, 1, 1);

    }

    public void computarJogada12() {

        aparecerBotao(b12, 1, 2);
        
    }

    public void computarJogada20() {

        aparecerBotao(b20, 2, 0);

    }

    public void computarJogada21() {

        aparecerBotao(b21, 2, 1);

    }

    public void computarJogada22() {
        
        aparecerBotao(b22, 2, 2);

    }


    private void aparecerBotao(Button botao, int linha, int coluna){

        botao.setOpacity(1);
        botao.setBackground(null);

        if( turno ){

            jogo[linha][coluna] = 1;
            botao.setText("X");

        } else {

            jogo[linha][coluna] = 2;
            botao.setText( "O" );

        }

        turno =! turno;
        botao.setDisable( true );

        System.out.println(jogo[linha][coluna]);

        checarVitoria(jogo);
    }

}
