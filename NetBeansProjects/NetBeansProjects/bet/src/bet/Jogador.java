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

public class Jogador {
    private int idJogador;
    private String nome, sobrenome, apelido, cpf, nacionalidade;
    private String dataNascimento;
    private Credito credito;
    private List<Aposta> apostas_array; 
    
    public Jogador() {
    }
        
    public Jogador(int idJogador, String nome, String sobrenome, String apelido, String cpf, String nacionalidade, String dataNascimento, Credito credito) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.credito = new Credito();
        this.apostas_array = new ArrayList<>();
    }
    
    // GETS E SETS
    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public List<Aposta> getApostas() {
        return apostas_array;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas_array = apostas;
    }
    
    // metodo para adicionar aposta
    public void addAposta(Aposta aposta){
        this.apostas_array.add(aposta);
    }
      
}
