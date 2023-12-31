import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("");
        Jogador jogador2 = new Jogador("");

        jogadores.add(jogador1);
        jogadores.add(jogador2);

        menu();
    }

    private static void menu() {
        int opcaoMenuPrincipal=0;
        do{
            System.out.println("""
                    ----- Seja bem vindo ao ... -----

                        [1] Começar jogo
                        [2] Sair

                    ---------------------------------""");
            opcaoMenuPrincipal = sc.nextInt();

        }while (opcaoMenuPrincipal<0 || opcaoMenuPrincipal>2);

        switch (opcaoMenuPrincipal) {
            case 1 -> {
                System.out.println("Digite seu nome jogador 1: ");
                String nomeJogador1 = sc.next();
                System.out.println("Digite seu nome jogador 2: ");
                String nomeJogador2 = sc.next();
                jogadores.get(0).nome = nomeJogador1;
                jogadores.get(1).nome = nomeJogador2;
                for (int i = 0; i < 2; i++) {
                    System.out.println("===============================================================");


                    System.out.println("OLA " + jogadores.get(i).nome + "\n ESTA PRONTO? pois é melhor que esteja");


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
                        int jogadoresEscolhaPeca = sc.nextInt();

                        switch (jogadoresEscolhaPeca) {
                            case 1 -> {
                                jogadores.get(i).pecas.add(new Mago(100, 35, "Mago"));
                            }
                            case 2 -> {
                                jogadores.get(i).pecas.add(new Arqueiro(100, 30, "Arqueiro"));
                            }
                            case 3 -> {
                                jogadores.get(i).pecas.add(new Assassino(80, 55, "Assassino"));
                            }
                            case 4 -> {
                                jogadores.get(i).pecas.add(new Cavaleiro(60, 60, "Cavaleiro"));
                            }
                            default -> {
                                System.out.print("Escolha uma peça valida");
                                j--;
                            }
                        }
                    }
                }
            }
            case 2 -> System.exit(0);
            default -> System.out.print("Escolha uma peça valida");
        }

        posicaoPecaJogador();
    }

    private static void posicaoPecaJogador() {
        Mapa mapa = new Mapa();
        for (int i = 0; i < 2; i++) {
            Jogador jogando;

            jogando = jogadores.get(i);

            System.out.println("Jogador "+jogando.nome+" sua vez de jogar!!");

            for (int j = 0; j < jogando.pecas.size(); j++) {
                int posicaoPeca = 0;
                mapa.ImprimeLista(jogando, jogadores.get(0));
                System.out.println("Onde deseja colocar o "+jogando.pecas.get(j).nome);
                posicaoPeca = sc.nextInt();
                if(i==0){
                    if(posicaoPeca>=18 && posicaoPeca<36 && mapa.getPosicoes().get(posicaoPeca).getUnidade() == null){
                        jogadores.get(0).prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        j--;
                    }
                }else {
                    if(posicaoPeca<18 && posicaoPeca>=0 && mapa.getPosicoes().get(posicaoPeca).getUnidade() == null){
                        jogadores.get(1).prePosicaoJogador1(jogando.pecas.get(j), posicaoPeca, mapa);
                    }else {
                        System.out.println("Escolha uma posição valida para a peça");
                        j--;
                    }
                }
            }
        }

        gamePlay(mapa);
    }

    private static void gamePlay(Mapa mapa){
        int vezJogador = 0;
        Jogador jogando;
        Jogador jogandoInimigo;
        Unidade peca;
        do{
            mapa.mapa();

            if (vezJogador%2 == 0) {
                jogando = jogadores.get(0);
                jogandoInimigo = jogadores.get(1);
            }else{
                jogando = jogadores.get(1);
                jogandoInimigo = jogadores.get(0);
            }

            System.out.println("Jogador "+jogando.nome+" é sua vez de jogar!!");
            System.out.println("\nPeças disponiveis: ");
            jogando.pecasDisponiveis(jogando, mapa, jogadores.get(0));

            System.out.println("A posicao da peça que deseja usar:");
            int escolhaPeca = sc.nextInt();

            if(mapa.getPosicoes().get(escolhaPeca).getUnidade() != null && jogando.pecas.contains(mapa.getPosicoes().get(escolhaPeca).getUnidade())){
                peca = mapa.getPosicoes().get(escolhaPeca).getUnidade();

                System.out.println("Peças inimigas na zona de ataque: ");
                if (!jogando.pecasAtacar(peca, jogandoInimigo, mapa)) {
                    System.out.println("Nenhuma pessoa na zona de ataque do "+peca.nome);
                }
                System.out.println("""
                O que pretende fazer?
                    [1] Trocar de peça
                    [2] Se mover
                    [3] Atacar
                """);
                int opcaoJogada = sc.nextInt();

                switch (opcaoJogada) {
                    case 3 -> {
                        Unidade pecaInimiga = null;
                            if (jogando.pecasAtacar(peca, jogandoInimigo, mapa)) {
                                System.out.println("A posicao da peça que deseja atacar: ");
                                int posicaoPecaInimiga = sc.nextInt();
                                if
                                (mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade() != null &&
                                        jogandoInimigo.pecas.contains(mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade())){
                                    if(peca.areaAtaque.contains(mapa.getPosicoes().get(posicaoPecaInimiga))){
                                        pecaInimiga = mapa.getPosicoes().get(posicaoPecaInimiga).getUnidade();
                                        peca.Atacar(pecaInimiga, jogandoInimigo, mapa);
                                    }
                                    if(pecaInimiga!=null){
                                        if (pecaInimiga.getVida() < 0) {
                                            System.out.println("Peça morta");
                                        } else {
                                            System.out.println("Peça inimiga: " + pecaInimiga.nome + " | vida: " + pecaInimiga.getVida());
                                        }
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
                    case 1 -> {
                        vezJogador--;
                    }
                }

                vezJogador++;
            }else {
                System.out.println("Escolha uma posição valida");
            }

        }while(verificaVitoria());

    }

    public static boolean verificaVitoria(){
        if(jogadores.get(0).pecas.size()==0){
            System.out.println("Jogador "+jogadores.get(1).nome+" venceu!!!");
            return false;
        }
        else if(jogadores.get(1).pecas.size()==0) {
            System.out.println("Jogador "+jogadores.get(0).nome+" venceu!!!");
            return false;
        }

        return true;
    }

}
