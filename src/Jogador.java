import java.util.ArrayList;

public class Jogador {
    String nome;
    ArrayList<Unidade> pecas;
    Jogador jogandoAgora;
    public Jogador(String nome){
        this.nome = nome;
        pecas = new ArrayList();
    }

    ArrayList<Posicao> prePosicao = new ArrayList<>(72);

    public void prePosicaoJogador1(Unidade peca, int posicao){
        for (int i = 0; i < 72; i++) {
            prePosicao.add(new Posicao());
        }
        prePosicao.get(posicao).setUnidade(peca);
        for (Posicao posicaoFor : prePosicao) {
            if (posicaoFor.getUnidade() == null){
                System.out.print("[  ] ");
            }
            else{
                System.out.print("["+posicaoFor.getUnidade().icon()+"]");
            }
            if ((prePosicao.indexOf(posicaoFor)+1)%6 == 0){
                System.out.println("\n");

            }

        }

    }
}
