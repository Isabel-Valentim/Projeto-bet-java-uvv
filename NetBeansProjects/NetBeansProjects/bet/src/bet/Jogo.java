/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet;

/**
 *
 * @author alunolab07
 */
import java.util.ArrayList;
import java.util.List;

public class Jogo {
    int idJogo;
    String descritivo;
    double apostaMax, premioMax;
    private List<Aposta> apostas_array;
    
    public Jogo(){
    }

    public Jogo(int idJogo, String descritivo, double apostaMax, double premioMax) {
        this.idJogo = idJogo;
        this.descritivo = descritivo;
        this.apostaMax = apostaMax;
        this.premioMax = premioMax;
        this.apostas_array = new ArrayList<>();
    }
    
     // Métodos GET
    public int getIdJogo() {
        return idJogo;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public double getApostaMax() {
        return apostaMax;
    }

    public double getPremioMax() {
        return premioMax;
    }

    // Métodos SET
    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public void setApostaMax(double apostaMax) {
        this.apostaMax = apostaMax;
    }

    public void setPremioMax(double premioMax) {
        this.premioMax = premioMax;
    }
    
    // metodo para adicionar aposta
    public void addAposta(Aposta aposta){
        this.apostas_array.add(aposta);
    }
    
}
