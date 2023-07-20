import java.util.ArrayList;

public class Cavaleiro extends Unidade {
    public Cavaleiro(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    @Override
    void Atacar(Unidade pecaAtacar, Jogador jogadorInimigo, Mapa mapa) {
        int vida = pecaAtacar.getVida();
        vida -= 60;
        pecaAtacar.setVida(vida);
        pecaMorta(pecaAtacar, jogadorInimigo, mapa);
    }

    @Override
    ArrayList<Posicao> possiveismovimentos(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        possiveisPosicoes.removeAll(posicoesNoMapa);
        int[] movimentos = { -7, -5, 5, 7 };

        for (int movimento : movimentos) {
            int novaPosicao = posicaoNoMapa + movimento;
            if (novaPosicao >= 0 && novaPosicao < 36
                    && !verificaExtremidade(novaPosicao) && posicoesNoMapa.get(novaPosicao).getUnidade() == null) {
                possiveisPosicoes.add(posicoesNoMapa.get(novaPosicao));
            }
        }

        return possiveisPosicoes;
    }

    @Override
    ArrayList<Posicao> VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();
        areaAtaque.removeAll(posicoesNoMapa);

        if(posicaoNoMapa-6 > 0){
            if (posicoesNoMapa.get(posicaoNoMapa - 6).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 6));
            }
        }
        if(posicaoNoMapa-12 > 0){
            if (posicoesNoMapa.get(posicaoNoMapa - 12).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 12));
            }
        }
        if(posicaoNoMapa-5 > 0){
            if (posicoesNoMapa.get(posicaoNoMapa -5).getUnidade() != null && !verificaExtremidade(posicaoNoMapa-5)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 5));
            }
        }

        if(posicaoNoMapa-7 > 0){
            if (posicoesNoMapa.get(posicaoNoMapa - 7).getUnidade() != null && !verificaExtremidade(posicaoNoMapa)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 7));
            }
        }

        if(posicaoNoMapa+6 < 36){
            if (posicoesNoMapa.get(posicaoNoMapa + 6).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 6));
            }
        }

        if(posicaoNoMapa+12 < 36){
            if (posicoesNoMapa.get(posicaoNoMapa + 12).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 12));
            }
        }

        if(posicaoNoMapa+5 < 36){
            if (posicoesNoMapa.get(posicaoNoMapa + 5).getUnidade() != null && !verificaExtremidade(posicaoNoMapa+5)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 5));
            }
        }

        if(posicaoNoMapa+7 < 36){
            if (posicoesNoMapa.get(posicaoNoMapa + 7).getUnidade() != null && !verificaExtremidade(posicaoNoMapa+1)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 7));
            }
        }


        return areaAtaque;
    }

    @Override
    String icon() {
        return "Ca";
    }
}
