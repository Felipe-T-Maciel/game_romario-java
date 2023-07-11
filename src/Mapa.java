import java.util.ArrayList;

public class Mapa {
    ArrayList<Posicao> posicoes = new ArrayList<>();

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    public void mapa(Jogador jogador){
        posicoes = jogador.getPrePosicao();
        System.out.println("\n====================================\n");
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
        System.out.print("====================================\n");
    }

}
