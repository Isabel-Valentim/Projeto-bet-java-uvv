/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bet;

import java.util.List;

/**
 *
 * @author alunolab07
 */
public class Bet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        //ARRAYS PARA ARMAZENAR OS JOGADORES CADASTRADOS E JOGOS CRIADOS
        List<Jogador> arrayJogadores = null;
        List<Jogo> arrayDeJogos = null;
        
        // CRIAR ALGUNS JOGOS JÁ EXISTENTES
        Jogo jogo1 = new Jogo(1, "Loteria", 10.0, 1000.0);
        Jogo jogo2 = new Jogo(2, "Roleta", 50.0, 500.0);
        arrayDeJogos.add(jogo1);
        arrayDeJogos.add(jogo2);
        
        // MENU DE CADASTRO
        while (true) {
            int menu = InOut.leInt("Cadastre um novo jogador \nDigite:\n0: para sair\n"
                    + "1: cadastrar jogador\n"
                    + "2: cadastrar novo jogo\n"
                    + "3: depositar credito de aposta\n"
                    + "4: cadastrar nova aposta\n"
                    + "5: cancelar aposta\n"
                    + "6: verificar saldo para aposta\n"
                    + "7: visualizar jogos disponíveis\n"
                    + "8: visualizar apostas ativas"
            );
            if (menu == 0) {
                break;
            } else if (menu == 1) {
                // CRIAR NOVO JOGADOR
                String nomeJogador = InOut.leString("Informe o seu nome: ");
                Jogador jogador = new Jogador();
                jogador.setNome(nomeJogador);
                arrayJogadores.add(jogador);
                InOut.MsgDeAviso("Bem-vindo à BET " + nomeJogador, "Seu cadastro foi concluído com sucesso " + jogador.getNome() + ".");      
            } else if (menu == 2){
                // CRIAR NOVO JOGO
                int idJogo = InOut.leInt("Informe um codigo para o novo jogo:");
                String descritivo = InOut.leString("Informe a descrição do jogo: ");
                double apostaMax = InOut.leDouble("Informe o máximo de aposta do jogo: ");
                double premioMax = InOut.leDouble("Informe o maximo de prêmio do jogo: ");
               
                Jogo jogo =  new Jogo();
                jogo.setIdJogo(idJogo);
                jogo.setDescritivo(descritivo);
                jogo.setApostaMax(apostaMax);
                jogo.setPremioMax(premioMax);
                arrayDeJogos.add(jogo);
                InOut.MsgDeAviso("Novo jogo cadastrado","Novo jogo '"+ jogo.getDescritivo() + "' cadastrado com sucesso.");
            }else if (menu == 7){
                // VISUALIZAR JOGOS DISPONÍVEIS
                
                //menu para consulta de jogos
                while (true) {
                    int menuVisJogos = InOut.leInt("Consulte os jogos no sistema.\nDigite:\n0: para sair\n"
                            + "1: consultar informações de um jogo pelo codigo\n"
                            + "2: consultar informações de um jogo pela descrição\n"
                            + "3: visualizar todos os jogos"
                    );
                    if (menuVisJogos == 0) {
                    break;
                    } else if (menu == 1) {
                        // PESQUISAR O JOGO PELO CODIGO
                        // solicitar o codigo do jogo
                        int codigoJogoProcurado = InOut.leString("Informe o código do jogo a pesquisar: ")
                        for (Jogo j: arrayDeJogos) {
                        if (j.getIdJogo() == codigoJogoProcurado) {
                            Jogo jogoEncontrado = j;
                            break; // Se encontrou, não é necessário continuar procurando
                        }
                    }
                    }}
                    
              
                 
                
            }
        }
    }


    //

        
    // JOGADOR ADICIONA CREDITO
    // JOGADOR CRIA UMA APOSTA 
    //CONDIÇÃO = CRÉDITO MAIOR QUE 0
    // Aposta aposta01 = new Aposta();       
    // jogador.addAposta(aposta01);
}
