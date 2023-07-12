import java.util.ArrayList;

public class Jogador {
    String nome;
    ArrayList<Unidade> pecas;

    public Jogador(String nome){
        this.nome = nome;
        pecas = new ArrayList();
    }

    public void prePosicaoJogador1(Unidade peca, int posicao, Mapa mapa){
        ArrayList<Posicao> newPosicao = mapa.getPosicoes();
        newPosicao.get(posicao).setUnidade(peca);
        mapa.setPosicoes(newPosicao);
    }

    public void pecasDisponiveis(Jogador jogando){
        for (Unidade peca:
             jogando.pecas) {
            System.out.println(jogando.pecas.indexOf(peca)+" - "+ peca.nome);
        }
    }

//    public void pecasAtacar(Unidade peca, Jogador jogadorInimigo, Mapa mapa){
//        for (Unidade pecaInimiga:
//             jogadorInimigo.pecas) {
//            if(peca.areaAtaque.get(mapa.getPosicoes().indexOf(pecaInimiga)).getUnidade() != null){
//                System.out.println("" +
//                        "");
//            }
//        }
//    }
}
