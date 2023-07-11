import java.util.ArrayList;

public class Jogador {
    String nome;
    ArrayList<Unidade> pecas;

    public Jogador(String nome){
        this.nome = nome;
        pecas = new ArrayList();
    }

    ArrayList<Posicao> prePosicao = inicializaArrayPreJogadas();

    public void prePosicaoJogador1(Unidade peca, int posicao){
        prePosicao.get(posicao).setUnidade(peca);
    }

    public void ImprimeLista(Jogador jogando, Jogador jogador1){
        Mapa mapa = new Mapa();
        System.out.println("=========================================");
        for (Posicao posicaoFor : prePosicao) {
            if(jogando.equals(jogador1)){
                if(prePosicao.indexOf(posicaoFor)<18){
                    System.out.print("[ J2 ]");
                }
                else if (prePosicao.get(prePosicao.indexOf(posicaoFor)).getUnidade() == null && prePosicao.indexOf(posicaoFor)>=17){
                    if(prePosicao.indexOf(posicaoFor)<10){
                        System.out.print("[  "+prePosicao.indexOf(posicaoFor)+" ]");
                    }else {
                        System.out.print("[ "+prePosicao.indexOf(posicaoFor)+" ]");
                    }
                }
                else{
                    System.out.print("[ "+prePosicao.get(prePosicao.indexOf(posicaoFor)).getUnidade().icon()+" ]");
                }
            }
            else {
                if(prePosicao.indexOf(posicaoFor)>17){
                    System.out.print("[ J1 ]");
                }
                else if (prePosicao.get(prePosicao.indexOf(posicaoFor)).getUnidade() == null && prePosicao.indexOf(posicaoFor)<=29){
                    System.out.print("[ "+prePosicao.indexOf(posicaoFor)+" ]");
                }
                else{
                    System.out.print("[ "+prePosicao.get(prePosicao.indexOf(posicaoFor)).getUnidade().icon()+" ]");
                }
            }
            if ((prePosicao.indexOf(posicaoFor)+1)%6 == 0){
                System.out.println("\n");

            }
            mapa.setPosicoes(prePosicao);
        }
    }

    public ArrayList<Posicao> getPrePosicao() {
        return prePosicao;
    }

    public ArrayList<Posicao> inicializaArrayPreJogadas(){
        ArrayList<Posicao> newA = new ArrayList<>(36);
        for (int i = 0; i < 36; i++) {
            newA.add(new Posicao());
        }

        return newA;
    }

}
