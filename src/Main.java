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
                            
                        ________________________
                        >""");
                        int jogadores = sc.nextInt();

                        switch (jogadores) {
                            case 1 -> {
                                if (i < 1) {
                                    jogador1.pecas.add(new Mago(100, 100, "Mago"));
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
            Jogador jogando;

            if(i==0){
                jogando = jogador1;
            }else {
                jogando = jogador2;
            }

            System.out.println("Jogador "+jogando.nome+" sua vez de jogar!!");

            for (int j = 0; j < jogando.pecas.size(); j++) {
                int posicaoPeca = 0;
                if (jogando.equals(jogador1)){
                    mapa.ImprimeLista(jogando, jogador1);
                    System.out.println("Onde deseja colocar o "+jogando.pecas.get(j).nome);
                    posicaoPeca = sc.nextInt();
                    if(posicaoPeca>=18 && posicaoPeca<36 && mapa.getPosicoes().get(posicaoPeca).getUnidade() == null){
                        jogador1.prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        j--;
                    }
                }
                else {
                    mapa.ImprimeLista(jogando, jogador1);
                    System.out.println("Onde deseja colocar o "+jogando.pecas.get(j).nome);
                    posicaoPeca = sc.nextInt();
                    if(posicaoPeca<18 && posicaoPeca>0 && mapa.getPosicoes().get(posicaoPeca).getUnidade() == null){
                        jogando.prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        j--;
                    }
                }
            }
        }

        gamePlay(jogador1, jogador2, mapa);
    }

    private static void gamePlay(Jogador jogador1, Jogador jogador2, Mapa mapa){
        int vezJogador = 0;
        Jogador jogando;
        Jogador jogandoInimigo;
        Unidade peca;
        do{
            mapa.mapa();

            if (vezJogador%2 == 0) {
                jogando = jogador1;
                jogandoInimigo = jogador2;
            }else{
                jogando = jogador2;
                jogandoInimigo = jogador1;
            }

            System.out.println("Jogador "+jogando.nome+" é sua vez de jogar!!");
            System.out.println("\nPeças disponiveis: ");
            jogando.pecasDisponiveis(jogando, mapa, jogador1);

            System.out.println("A posicao da peça que deseja usar:");
            int escolhaPeca = sc.nextInt();

            if(mapa.getPosicoes().get(escolhaPeca).getUnidade() != null && jogando.pecas.contains(mapa.getPosicoes().get(escolhaPeca).getUnidade())){
                peca = mapa.getPosicoes().get(escolhaPeca).getUnidade();

                System.out.println("""
                O que pretende fazer?
                    [1] Atacar
                    [2] Se mover
                """);
                int opcaoJogada = sc.nextInt();

                switch (opcaoJogada) {
                    case 1 -> {
                        System.out.println("Pecas inimigas dentro do alcance do " + peca.nome + ": ");
                        if (jogando.pecasAtacar(peca, jogandoInimigo, mapa)) {
                            System.out.println("A posicao da peça que deseja atacar: ");
                            int posicaoPecaInimiga = sc.nextInt();
                            if
                            (mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade() != null &&
                                    jogandoInimigo.pecas.contains(mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade())){
                                Unidade pecaInimiga = mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade();
                                peca.Atacar(pecaInimiga, jogandoInimigo, mapa);
                                if (pecaInimiga.getVida() < 0) {
                                    System.out.println("Peça morta");
                                } else {
                                    System.out.println("Peça inimiga: " + pecaInimiga.nome + " | vida: " + pecaInimiga.getVida());
                                }
                            }else {
                                System.out.println("A posição da peça escolhida é invalida");
                            }

                        } else {
                            System.out.println("Nenhuma peça na area de ataque do " + peca.nome);
                        }
                    }
                    case 2 -> {
                        System.out.println("Seus movimentos possiveis são: ");
                        mapa.possiveisMovimentos(peca);
                        System.out.println("Para onde deseja se mover: ");
                        int movimento = sc.nextInt();
                        if (peca.possiveisPosicoes.contains(mapa.posicoes.get(movimento))) {
                            peca.mover(mapa, peca, movimento);
                            System.out.println("peca movida");
                        } else {
                            System.out.println("Movimento invalido");
                        }
                    }
                }

                vezJogador++;
            }else {
                System.out.println("Escolha uma posição valida");
            }

        }while(verificaVitoria(jogador1, jogador2));

    }

    public static boolean verificaVitoria(Jogador jogador1, Jogador jogador2){
        if(jogador1.pecas.size()<=0){
            System.out.println("Jogador "+jogador2.nome+" venceu!!!");
            return false;
        }
        else if(jogador2.pecas.size()<=0) {
            System.out.println("Jogador "+jogador1.nome+" venceu!!!");
            return false;
        }

        return true;
    }

}
