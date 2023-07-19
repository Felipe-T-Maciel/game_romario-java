import java.util.ArrayList;

public class Mapa {
    ArrayList<Posicao> posicoes = inicializaArrayPreJogadas();

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    public void ImprimeLista(Jogador jogando, Jogador jogador1){
        System.out.println("=========================================");
        for (Posicao posicaoFor : posicoes) {
            if(jogando.equals(jogador1)){
                if(posicoes.indexOf(posicaoFor)<18){
                    System.out.print("[ J2 ]");
                }
                else if (posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade() == null && posicoes.indexOf(posicaoFor)>=17){
                    if(posicoes.indexOf(posicaoFor)<10){
                        System.out.print("[  "+posicoes.indexOf(posicaoFor)+" ]");
                    }else {
                        System.out.print("[ "+posicoes.indexOf(posicaoFor)+" ]");
                    }
                }
                else{
                    System.out.print("[ "+posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade().icon()+" ]");
                }
            }
            else {
                if(posicoes.indexOf(posicaoFor)>17){
                    System.out.print("[ J1 ]");
                }
                else if (posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade() == null && posicoes.indexOf(posicaoFor)<=29){
                    System.out.print("[ "+posicoes.indexOf(posicaoFor)+" ]");
                }
                else{
                    System.out.print("[ "+posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade().icon()+" ]");
                }
            }
            if ((posicoes.indexOf(posicaoFor)+1)%6 == 0){
                System.out.println("\n");

            }
        }
    }

    public void mapa(){
        for (Posicao posicaoFor : posicoes) {
            if (posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade() == null){
                    System.out.print("[    ]");
            }
            else{
                System.out.print("[ "+posicoes.get(posicoes.indexOf(posicaoFor)).getUnidade().icon()+" ]");
            }
            if ((posicoes.indexOf(posicaoFor)+1)%6 == 0){
                System.out.println("\n");

            }
        }
    }

    public ArrayList<Posicao> inicializaArrayPreJogadas(){
        ArrayList<Posicao> newA = new ArrayList<>(36);
        for (int i = 0; i < 36; i++) {
            newA.add(new Posicao());
        }
        return newA;
    }

    public int getPosicaoPeca(Unidade peca){
        for (int i = 0; i < posicoes.size(); i++) {
            if(posicoes.get(i).getUnidade() == peca){
                return i;
            }
        }
        return 0;
    }

}
