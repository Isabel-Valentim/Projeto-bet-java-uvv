package bet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunolab07
 */

import java.util.ArrayList;
import java.util.List;

public class Aposta {
        private int idAposta, repetir;
        private double valorAposta;
        private List<Jogo> jogo_array; 
    
    public Aposta(){
    }

    public Aposta(int idAposta, int repetir, double valorAposta) {
        this.idAposta = idAposta;
        this.repetir = repetir;
        this.valorAposta = valorAposta;
        this.jogo_array = new ArrayList<>(); 
    }
    // metodo para adicionar jogo
    public void addJogo(Jogo jogo){
        this.jogo_array.add(jogo);
    }
     // getters e setters
    public int getIdAposta() {
        return idAposta;
    }

    public void setIdAposta(int idAposta) {
        this.idAposta = idAposta;
    }

    public int getRepetir() {
        return repetir;
    }

    public void setRepetir(int repetir) {
        this.repetir = repetir;
    }

    public double getValorAposta() {
        return valorAposta;
    }

    public void setValorAposta(double valorAposta) {
        this.valorAposta = valorAposta;
    }

    public List<Jogo> getJogo_array() {
        return jogo_array;
    }

    public void setJogo_array(List<Jogo> jogo_array) {
        this.jogo_array = jogo_array;
    }
     
}
