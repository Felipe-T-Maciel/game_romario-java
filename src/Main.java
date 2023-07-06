import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
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

        switch (opcaoMenuPrincipal){
            case 1:
                System.out.println("Digite seu nome jogador 1: ");
                String nomeJogador1 = sc.next();

                System.out.println("Digite seu nome jogador 2: ");
                String nomeJogador2 = sc.next();

                Jogador jogador1 = new Jogador(nomeJogador1);
                Jogador jogador2 = new Jogador(nomeJogador2);

                for (int i = 1; i < 3; i++) {
                    if (i<2){
                        System.out.println("OLA "+jogador1.nome+"\n ESTA PRONTO? pois é melhor que esteja");
                    }
                    else {
                        System.out.println("OLA "+jogador2.nome+"\n ESTA PRONTO? pois é melhor que esteja");

                    }
                    for (int j = 1; j < 7; j++) {
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

                        switch (jogadores){
                            case 1:
                                if(i<2){
                                    jogador1.pecas.add(new Mago(100, 35,"mago"));
                                }
                                else {
                                    jogador2.pecas.add(new Mago(100, 35,"mago"));
                                }
                                break;
                            case 2:
                                if(i<2){
                                    jogador1.pecas.add(new Arqueiro(100,15,"arqueiro"));
                                }else {
                                    jogador2.pecas.add(new Arqueiro(100,15,"arqueiro"));
                                }
                                break;

                        }
                    }
                }
        }
    }
}
