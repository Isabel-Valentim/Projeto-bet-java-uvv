package bet;

import bet.InOut;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random; 

public class MainFrame extends JFrame {

    private JButton jogadorButton;
    private JButton casaDeApostasButton;
    ArrayList<Jogador> arrayDeJogadores = new ArrayList<>();
    ArrayList<Jogo> arrayDeJogos = new ArrayList<>();

    public MainFrame() {
        this.arrayDeJogadores = new ArrayList<>();
        setTitle("Sistema de Apostas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jogadorButton = new JButton("Jogador");
        jogadorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão Jogador
                abrirMenuJogador();
            }
        });

        casaDeApostasButton = new JButton("Casa de Apostas");
        casaDeApostasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão Casa de Apostas
                abrirMenuCasaDeApostas();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(jogadorButton);
        panel.add(casaDeApostasButton);

        add(panel);
        setVisible(true);
    }

    private void abrirMenuJogador() {
        // Implementar lógica para abrir o menu do jogador
        // Aqui você pode criar outra janela JFrame com as opções desejadas
        // Exemplo:
        JFrame jogadorFrame = new JFrame("Menu do Jogador");
        jogadorFrame.setSize(300, 200);
        jogadorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jogadorFrame.setLocationRelativeTo(null);

        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica 
                String nomeJogador;
                do {
                    nomeJogador = InOut.leString("Informe o seu nome:* ");
                } while (nomeJogador == null || nomeJogador.trim().isEmpty());
                String sobrenomeJogador = InOut.leString("Informe o seu sobrenome: ");
                String apelidoJogador = InOut.leString("Informe o seu apelido: ");
                String cpfJogador;
                do {
                    cpfJogador = InOut.leString("Informe o seu CPF:* ");
                } while (cpfJogador == null || nomeJogador.trim().isEmpty());
                String nacionalidadeJogador = InOut.leString("Informe o sua nacionalidade: ");
                String dataNascimentoJogador = InOut.leString("Informe sua data de nascimento:  ");
                if (nomeJogador != null && cpfJogador != null) {
                    Jogador jogador = new Jogador();
                    jogador.setNome(nomeJogador);
                    jogador.setSobrenome(sobrenomeJogador);
                    jogador.setApelido(apelidoJogador);
                    jogador.setCpf(cpfJogador);
                    jogador.setNacionalidade(nacionalidadeJogador);
                    jogador.setDataNascimento(dataNascimentoJogador);
                    arrayDeJogadores.add(jogador);
                    InOut.MsgDeAviso("Bem-vindo à BET " + nomeJogador, "Seu cadastro foi concluído com sucesso " + jogador.getNome() + ".");
                } else {
                    InOut.MsgDeAviso("Erro", "Não foi possível concluir seu cadastro. Certifique-se de informar seu Nome e CPF.");
                }
            }
        });

        JButton visJogosButton = new JButton("Visualizar jogos");
        visJogosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica 
                String jogosDisponiveis = "";
                for (Jogo j : arrayDeJogos) {
                    jogosDisponiveis += "\nJogo:\nCódigo: " + j.getIdJogo() + "\nDescritivo: " + j.getDescritivo() + "\nAposta Máxima: " + j.getApostaMax() + "\nPrêmio Máximo: " + j.getPremioMax();
                }
                InOut.MsgDeInformacao("TODOS OS JOGOS", jogosDisponiveis);

            }
        });

        JButton visSaldoButton = new JButton("Visualizar saldo");
        visSaldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfJogadorProcurado;
                do {
                    cpfJogadorProcurado = InOut.leString("Infome o cpf do jogador para verificar o saldo: ");
                } while (cpfJogadorProcurado == null || cpfJogadorProcurado.trim().isEmpty());

                double saldo = 0;

                for (Jogador eJogador : arrayDeJogadores) {
                    if (eJogador.getCpf() == cpfJogadorProcurado) {
                        saldo = eJogador.visualizarSaldo();
                    }
                }
                InOut.MsgDeInformacao("Crédito do Jogador", "Saldo: " + saldo);

            }
        });

        JButton depositarButton = new JButton("Depositar");
        depositarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfJogadorProcurado;
                do {
                    cpfJogadorProcurado = InOut.leString("Informe o cpf do jogador para depositar o saldo:* ");
                } while (cpfJogadorProcurado == null || cpfJogadorProcurado.trim().isEmpty());

                double valorDepositar;
                do {
                    valorDepositar = InOut.leInt("Informe o valor a depositar:* ");
                } while (valorDepositar <= 0);

                double saldo = 0;

                for (Jogador eJogador : arrayDeJogadores) {
                    if (eJogador.getCpf() == null ? cpfJogadorProcurado == null : eJogador.getCpf().equals(cpfJogadorProcurado)) {
                        if (eJogador.getCredito() == null) {
                            Credito credito = new Credito();
                            credito.setSaldo(0);
                            eJogador.setCredito(credito);
                        }
                        eJogador.adicionarCredito(valorDepositar);
                        saldo = eJogador.visualizarSaldo();

                    } else {
                        InOut.MsgDeAviso("Erro", "Jogador não encontrado.");
                    }
                }
                InOut.MsgDeInformacao("Saldo atualizado do Jogador", "Saldo: " + saldo);

            }
        });

        JButton sacarButton = new JButton("Sacar");
        sacarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfJogadorProcurado;
                do {
                    cpfJogadorProcurado = InOut.leString("Informe o cpf do jogador para sacar o saldo:* ");
                } while (cpfJogadorProcurado == null || cpfJogadorProcurado.trim().isEmpty());

                double valorDepositar;
                do {
                    valorDepositar = InOut.leInt("Informe o valor a sacar:* ");
                } while (valorDepositar <= 0);

                double saldo = 0;

                for (Jogador eJogador : arrayDeJogadores) {
                    if (eJogador.getCpf() == null ? cpfJogadorProcurado == null : eJogador.getCpf().equals(cpfJogadorProcurado)) {
                        if (eJogador.getCredito() == null) {
                            Credito credito = new Credito();
                            credito.setSaldo(0);
                            eJogador.setCredito(credito);
                        }
                        if (eJogador.subtrairCredito(valorDepositar) == true) {
                            saldo = eJogador.visualizarSaldo();
                            InOut.MsgDeInformacao("Saldo atualizado do Jogador", "Saldo: " + saldo);
                        } else {
                            InOut.MsgDeInformacao("Erro", "Não há saldo suficiente");
                        }

                    } else {
                        InOut.MsgDeAviso("Erro", "Jogador não encontrado.");
                    }
                }

            }
        });

        JButton apostaButton = new JButton("Apostar");
        apostaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfJogadorProcurado;
                do {
                    cpfJogadorProcurado = InOut.leString("Informe o cpf do jogador que deseja apostar:* ");
                } while (cpfJogadorProcurado == null || cpfJogadorProcurado.trim().isEmpty());
                int idJogoProcurado;
                do {
                    idJogoProcurado = InOut.leInt("Informe o id do jogo que gostaria de pesquisar:* ");
                } while (idJogoProcurado <= 0);
                double valorAposta; 
                do{
                   valorAposta = InOut.leDouble("Informe o valor que deseja apostar:* "); 
                }while(valorAposta <= 0);

                //verificar se tem jogador
                //verificar se tem saldo e subtrair
                //verificar se tem jogo
                //verificar aposta máxima
                
                for (Jogador eJogador : arrayDeJogadores) {
                    if (!(eJogador.getCpf().equals(cpfJogadorProcurado))) {
                        InOut.MsgDeAviso("Erro", "Jogador não encontrado.");
                    }else{      
                        // verficar saldo do jogador e subtrai
                        if (eJogador.getCredito() == null || eJogador.visualizarSaldo() <= 0){
                            InOut.MsgDeAviso("Erro", "Não há saldo suficiente.");
                        }else{
                            double saldo = 0;
                            if (eJogador.subtrairCredito(valorAposta) == false) {
                                InOut.MsgDeAviso("Erro", "Não há saldo suficiente.");
                            } else {
                                double apostaMaxJogoProcurado = 0;
                                // verificar se tem jogo
                                for(Jogo eJogo : arrayDeJogos){
                                    if (!(eJogo.getIdJogo() == idJogoProcurado)) {
                                        InOut.MsgDeAviso("Erro", "O jogo procurado não existe.");
                                    }else{
                                        apostaMaxJogoProcurado = eJogo.getApostaMax();
                                        //verificar aposta max
                                        if(apostaMaxJogoProcurado < valorAposta){
                                            InOut.MsgDeAviso("Erro", "A aposta excete o valor máximo ");
                                        }else{
                                            // executar aposta
                                            ArrayList<Aposta> apostas = new ArrayList<>(); 
                                            eJogador.setApostas(apostas);
                                            Aposta aposta = new Aposta();
                                            Random random = new Random(); 
                                            int idAleatorio = random.nextInt(100); 
                                            aposta.setIdAposta(idAleatorio);
                                            aposta.setValorAposta(valorAposta);
                                            eJogador.addAposta(aposta);
                                            saldo = eJogador.visualizarSaldo();
                                            InOut.MsgDeInformacao("ok", "ok");
                                        }
                                    }
                                }
                                
                                
                            }
                        }
                    }
                }


                
            }
        });

        JPanel panel = new JPanel();
        panel.add(cadastroButton);
        panel.add(visJogosButton);
        panel.add(visSaldoButton);
        panel.add(depositarButton);
        panel.add(sacarButton);
        panel.add(apostaButton);
        jogadorFrame.add(panel);
        jogadorFrame.setVisible(true);
    }

    private void abrirMenuCasaDeApostas() {
        JFrame casaDeApostaFrame = new JFrame("Menu do Jogador");
        casaDeApostaFrame.setSize(300, 200);
        casaDeApostaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        casaDeApostaFrame.setLocationRelativeTo(null);

        // colocar aqui os botões
        JButton criarJogoButton = new JButton("Criar novo Jogo");
        criarJogoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica 
                int idJogo;
                do {
                    idJogo = InOut.leInt("Informe o id do jogo:* ");
                } while (idJogo <= 0);
                String descritivoJogo;
                do {
                    descritivoJogo = InOut.leString("Informe o descritivo do Jogo:* ");
                } while (descritivoJogo == null || descritivoJogo.trim().isEmpty());
                double apostaMaxJogo;
                do {
                    apostaMaxJogo = InOut.leDouble("Informe a aposta máxima: ");
                } while (apostaMaxJogo <= 0);
                double premioMaxJogo;
                do {
                    premioMaxJogo = InOut.leDouble("Informe o prêmio máximo: ");
                } while (premioMaxJogo <= 0);
                if (idJogo > 0 && descritivoJogo != null && apostaMaxJogo > 0 && premioMaxJogo > 0) {
                    Jogo jogo = new Jogo();
                    jogo.setIdJogo(idJogo);
                    jogo.setDescritivo(descritivoJogo);
                    jogo.setApostaMax(apostaMaxJogo);
                    jogo.setPremioMax(premioMaxJogo);
                    arrayDeJogos.add(jogo);
                    InOut.MsgDeAviso("Jogo Cadastrado", "Concluído");
                } else {
                    InOut.MsgDeAviso("Erro", "Não foi possível cadastrar novo jogo. Certifique-se de informar o id do jogo e o o descritivo.");
                }

            }
        });

        JPanel panel = new JPanel();
        panel.add(criarJogoButton);
        casaDeApostaFrame.add(panel);
        casaDeApostaFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
