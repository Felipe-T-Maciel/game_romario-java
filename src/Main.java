import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("");
        Jogador jogador2 = new Jogador("");


        menu(jogador1, jogador2);
    }
    private static void menu(Jogador jogador1, Jogador jogador2) {
        int opcaoMenuPrincipal=0;
        do{
            System.out.println("""
                    ----- Seja bem vindo ao ... -----
                    
                        [1] Começar jogo
                        [2] Sair
                        
                    ---------------------------------""");
            opcaoMenuPrincipal = sc.nextInt();

        }while (opcaoMenuPrincipal<0 || opcaoMenuPrincipal>2);

        switch (opcaoMenuPrincipal){
            case 1:
                System.out.println("Digite seu nome jogador 1: ");
                String nomeJogador1 = sc.next();

                System.out.println("Digite seu nome jogador 2: ");
                String nomeJogador2 = sc.next();

                jogador1.nome = nomeJogador1;
                jogador2.nome = nomeJogador2;

                for (int i = 1; i < 3; i++) {
                    System.out.println("===============================================================");

                    if (i<2){
                        System.out.println("OLA "+jogador1.nome+"\n ESTA PRONTO? pois é melhor que esteja");
                    }
                    else {
                        System.out.println("OLA "+jogador2.nome+"\n ESTA PRONTO? pois é melhor que esteja");

                    }
                    System.out.println("===============================================================");

                    for (int j = 1; j < 4; j++) {
                        System.out.println("""
                        Escolha seus campeões:
                        
                        Tipo longo alcance:
                            
                            [1] Mago
                            [2] Arqueiro
                        
                        Tipo curto alcance:
                            
                            [3] Assassino
                            [4] Cavaleiro
                        
                        Tanque:
                            
                            [5] Tanque-Wesly
                        ________________________
                        >""");
                        int jogadores = sc.nextInt();

                        switch (jogadores) {
                            case 1 -> {
                                if (i < 2) {
                                    jogador1.pecas.add(new Mago(100, 35, "Mago"));
                                } else {
                                    jogador2.pecas.add(new Mago(100, 35, "Mago"));
                                }
                            }
                            case 2 -> {
                                if (i < 2) {
                                    jogador1.pecas.add(new Arqueiro(100, 15, "Arqueiro"));
                                } else {
                                    jogador2.pecas.add(new Arqueiro(100, 15, "Arqueiro"));
                                }
                            }
                            case 3 -> {
                                if (i < 2) {
                                    jogador1.pecas.add(new Assassino(80, 40, "Assassino"));
                                } else {
                                    jogador2.pecas.add(new Assassino(80, 40, "Assassino"));

                                }
                            }
                            case 4 -> {
                                if (i < 2) {
                                    jogador1.pecas.add(new Cavaleiro(60, 60, "Cavaleiro"));
                                } else {
                                    jogador2.pecas.add(new Cavaleiro(60, 60, "Cavaleiro"));

                                }
                            }
                            case 5 -> {
                                if (i < 2) {
                                    jogador1.pecas.add(new Tanque(200, 5, "Tanque"));
                                } else {
                                    jogador2.pecas.add(new Tanque(200, 5, "Tanque"));

                                }
                            }
                            default -> {
                                System.out.print("Escolha uma peça valida");
                                return;
                            }
                        }
                    }
                }
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("Escolha uma peça valida");
                break;
        }

        posicaoPecaJogador(jogador1, jogador2);
    }

    private static void posicaoPecaJogador(Jogador jogador1, Jogador jogador2) {

        for (int i = 0; i < 2; i++) {
            Jogador jogando;
            System.out.println("Que jogador esta jogando?");
            String nome = sc.next();
            if(nome.equals(jogador1.nome)){
                jogando = jogador1;
            }else if(nome.equals(jogador2.nome)){
                jogando = jogador2;
            }
            else {
                return;
            }
            Mapa mapa = new Mapa();

            for (int j = 0; j < jogando.pecas.size(); j++) {
                System.out.println("Onde deseja colocar o "+jogando.pecas.get(i).nome);
                int posicaoPeca = sc.nextInt();
                if (jogando.equals(jogador1)){
                    if(posicaoPeca>=42 && posicaoPeca<72){
                        jogando.prePosicaoJogador1(jogando.pecas.get(i), posicaoPeca);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        return;
                    }
                }
                else {
                    if(posicaoPeca<=29 && posicaoPeca>0){
                        jogando.prePosicaoJogador1(jogando.pecas.get(i), posicaoPeca);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        return;
                    }
                }
            }
        }

    }
}
