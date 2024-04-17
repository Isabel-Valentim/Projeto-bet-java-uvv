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

public class Credito {
    private double saldo;
    private String validade, moeda;
    private boolean bloqueado;
    
    public Credito(){
    }

    public Credito(double saldo, String validade, String moeda, boolean bloqueado) {
        this.saldo = saldo;
        this.validade = validade;
        this.moeda = moeda;
        this.bloqueado = bloqueado;
    }
    
    
    
}
