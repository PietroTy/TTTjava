package br.edu.ifsp.classes;

public class Jogador {
    private String nome;
    private char time;
    private boolean ganhou;

    public String getNome() {
        return nome;
    }

    public char getTime() {
        return time;
    }

    public boolean getGanhou(){
        return ganhou;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTime(char time) {
        this.time = time;
    }
}
