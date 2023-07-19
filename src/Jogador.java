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

    public void pecasDisponiveis(Jogador jogando, Mapa mapa, Jogador jogador1){
        for (Unidade peca:
             jogando.pecas) {
            peca.VerificaAreaAtaque(mapa, jogando, jogador1, peca);
        }
        for (Unidade peca:
             jogando.pecas) {
            System.out.println(mapa.getPosicaoPeca(peca)+" - "+ peca.nome);
        }
    }

    public void pecasAtacar(Unidade peca, Jogador jogadorInimigo, Mapa mapa){

        for (Posicao pecaInimiga:
             peca.areaAtaque) {
            for (Unidade pecaContra:
                    jogadorInimigo.pecas) {
                if (pecaContra == pecaInimiga.getUnidade()) {
                    System.out.println(mapa.getPosicaoPeca(pecaInimiga.getUnidade())+" - "+pecaInimiga.getUnidade().nome);
                }
            }
        }
    }
}
