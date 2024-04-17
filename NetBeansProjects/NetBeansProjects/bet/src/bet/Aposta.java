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
        // aposta tem JOGO - COLOCAR UM ARRAY AQUI 
    
    public Aposta(){
    }

    public Aposta(int idAposta, int repetir, double valorAposta) {
        this.idAposta = idAposta;
        this.repetir = repetir;
        this.valorAposta = valorAposta;
    }
     
}
