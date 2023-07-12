import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("felipe");
        Jogador jogador2 = new Jogador("julio");


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

                for (int i = 0; i < 2; i++) {
                    System.out.println("===============================================================");

                    if (i<1){
                        System.out.println("OLA "+jogador1.nome+"\n ESTA PRONTO? pois é melhor que esteja");
                    }
                    else {
                        System.out.println("OLA "+jogador2.nome+"\n ESTA PRONTO? pois é melhor que esteja");

                    }
                    System.out.println("===============================================================");

                    for (int j = 0; j < 3; j++) {
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
                                if (i < 1) {
                                    jogador1.pecas.add(new Mago(100, 35, "Mago"));
                                } else {
                                    jogador2.pecas.add(new Mago(100, 35, "Mago"));
                                }
                            }
                            case 2 -> {
                                if (i < 1) {
                                    jogador1.pecas.add(new Arqueiro(100, 15, "Arqueiro"));
                                } else {
                                    jogador2.pecas.add(new Arqueiro(100, 15, "Arqueiro"));
                                }
                            }
                            case 3 -> {
                                if (i < 1) {
                                    jogador1.pecas.add(new Assassino(80, 40, "Assassino"));
                                } else {
                                    jogador2.pecas.add(new Assassino(80, 40, "Assassino"));

                                }
                            }
                            case 4 -> {
                                if (i < 1) {
                                    jogador1.pecas.add(new Cavaleiro(60, 60, "Cavaleiro"));
                                } else {
                                    jogador2.pecas.add(new Cavaleiro(60, 60, "Cavaleiro"));

                                }
                            }
                            case 5 -> {
                                if (i < 1) {
                                    jogador1.pecas.add(new Tanque(200, 5, "Tanque"));
                                } else {
                                    jogador2.pecas.add(new Tanque(200, 5, "Tanque"));

                                }
                            }
                            default -> {
                                System.out.print("Escolha uma peça valida");
                                j--;
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
        Mapa mapa = new Mapa();
        for (int i = 0; i < 2; i++) {
            Jogador jogando = new Jogador("");

            if(i==0){
                jogando = jogador1;
            }else {
                jogando = jogador2;
            }

            System.out.println("Jogador "+jogando.nome+" sua vez de jogar!!");

            for (int j = 0; j < jogando.pecas.size(); j++) {
                int posicaoPeca = 0;
                if (jogando.equals(jogador1)){
                    do{
                        mapa.ImprimeLista(jogando, jogador1);
                        System.out.println("Onde deseja colocar o "+jogando.pecas.get(j).nome);
                        posicaoPeca = sc.nextInt();
                        if(posicaoPeca>=19 && posicaoPeca<36){
                            jogador1.prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                        }else {
                            System.out.println("Escolha uma posição valida para a peça");
                        }
                    }while (posicaoPeca<19 || posicaoPeca>36);
                }
                else {
                    do{
                        mapa.ImprimeLista(jogando, jogador1);
                        System.out.println("Onde deseja colocar o "+jogando.pecas.get(j).nome);
                        posicaoPeca = sc.nextInt();
                        if(posicaoPeca<=18 && posicaoPeca>0){
                            jogando.prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                        }else {
                            System.out.println("Escolha uma posição valida para a peça");
                        }
                    }while (posicaoPeca>18 || posicaoPeca<0);
                }
            }
        }

        gamePlay(jogador1, jogador2, mapa);
    }

    private static void gamePlay(Jogador jogador1, Jogador jogador2, Mapa mapa){
            mapa.mapa();
            int vezJogador = 0;
            Jogador jogando;
            Jogador jogandoInimigo;
            Unidade peca;
            int ultimaJogada = 0;
            //while

            if (vezJogador%2 == 0) {
                jogando = jogador1;
                jogandoInimigo = jogador2;
            }else{
                jogando = jogador2;
                jogandoInimigo = jogador1;
            }

            System.out.println("Jogador "+jogando.nome+" é sua vez de jogar!!");
            System.out.println("""
                    O que pretende fazer?
                        [1] Atacar
                        [2] Se mover
                    """);
                    int opcaoJogada = sc.nextInt();
                    ultimaJogada = opcaoJogada;

                    switch (opcaoJogada){
                        case 1:
                            System.out.println("\nPeças disponiveis: ");
                            jogando.pecasDisponiveis(jogando);

                            System.out.println("A posicao da peça que deseja usar?");
                            int escolhaPeca = sc.nextInt();

                            peca = jogando.pecas.get(escolhaPeca).getPosicao().getUnidade();
                            System.out.println("Pecas inimigas dentro do alcance do "+peca.nome+": ");



                    }

            vezJogador++;

    }

}
