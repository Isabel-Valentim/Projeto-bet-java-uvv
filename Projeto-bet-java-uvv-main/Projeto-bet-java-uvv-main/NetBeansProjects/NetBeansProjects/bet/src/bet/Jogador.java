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
    //CREDITO
    //ADICIONAR VALOR A SALDO DE CRÉDITO
    public void adicionarCredito(double valor) {
        this.credito.setSaldo(this.credito.getSaldo() + valor);
    }
    // SUBTRAIR VALOR DO SALDO DE CRÉDITO
    public boolean subtrairCredito(double valor) {
        // VERIFICAR SALDO ATUAL
        if (this.credito.getSaldo() >= valor) {
            this.credito.setSaldo(this.credito.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }
    //VISUALIZAR APENAS O SALDO DO CREDITO
    public double visualizarSaldo() {
        return this.credito.getSaldo();
    }
    // APOSTA
    // método para mostrar todas as postas do jogador
    public String mostrarTodasApostas() {
        if (this.apostas_array.isEmpty()) {
            return "O jogador não possui nenhuma aposta.";
        } else {
            System.out.println("Apostas do jogador " + this.nome + ":");
            for (Aposta aposta : this.apostas_array) {
                String mensagem = "ID da Aposta: " + aposta.getIdAposta();
                mensagem += "Repetir: " + aposta.getRepetir();
                mensagem += "Valor da Aposta: " + aposta.getValorAposta();

            }
            return null;
        }

    }

    // metodo para adicionar aposta
    public void addAposta(Aposta aposta) {
        this.apostas_array.add(aposta);
    }

    //criar aposta
    public void criarAposta(int idAposta, int repetir, double valorAposta) {
        Aposta novaAposta = new Aposta(idAposta, repetir, valorAposta);
        this.addAposta(novaAposta);
    }

    //encontrar aposta
    public Aposta lerAposta(int idAposta) {
        for (Aposta aposta : this.apostas_array) {
            if (aposta.getIdAposta() == idAposta) {
                return aposta;
            }
        }
        return null; // Retorna null se a aposta não for encontrada
    }
    // atualizar uma aposta existente e retornar os dados atualizados

    public String atualizarAposta(int idAposta, int repetir, double valorAposta) {
        Aposta aposta = this.lerAposta(idAposta);
        if (aposta != null) {
            aposta.setRepetir(repetir);
            aposta.setValorAposta(valorAposta);
            // Montar a string com os dados atualizados da aposta
            String mensagem = "Aposta atualizada com sucesso:\n";
            mensagem += "ID da Aposta: " + aposta.getIdAposta() + "\n";
            mensagem += "Repetir: " + aposta.getRepetir() + "\n";
            mensagem += "Valor da Aposta: " + aposta.getValorAposta() + "\n";
            // Retornar a mensagem com os dados atualizados
            return mensagem;
        } else {
            return "Aposta não encontrada.";
        }
    }

    // excluir aposta
    public void excluirAposta(int idAposta) {
        Aposta aposta = this.lerAposta(idAposta);
        if (aposta != null) {
            this.apostas_array.remove(aposta);
            System.out.println("Aposta excluída com sucesso.");
        } else {
            System.out.println("Aposta não encontrada.");
        }
    }

}
