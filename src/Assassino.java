import java.util.ArrayList;

public class Assassino extends Unidade{

    public Assassino(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    @Override
    void Atacar(Unidade pecaAtacar) {
        int vida = pecaAtacar.getVida();
        vida -= 40;
        pecaAtacar.setVida(vida);
    }

    @Override
    ArrayList<Posicao> possiveismovimentos(Mapa mapa, Jogador jogandoAgora, Jogador jogador) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoMapa = mapa.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        if(jogandoAgora == jogador){
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null && (posicaoNoMapa+6) < 72){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-12) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-12));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+1) == null && !verificaExtremidade(posicaoNoMapa+1)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-1) == null && !verificaExtremidade(posicaoNoMapa)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
            }
        }else {
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null && (posicaoNoMapa+6) < 72){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+12) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+12));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-1) == null && !verificaExtremidade(posicaoNoMapa)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+1) == null && !verificaExtremidade(posicaoNoMapa+1)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
            }
        }


        return possiveisPosicoes;
    }

    @Override
    ArrayList<Posicao> VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador) {

        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoMapa = mapa.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        if(jogandoAgora == jogador) {
            if (posicoesNoMapa.get(posicaoNoMapa - 6) == null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 6));
            }
            if (posicoesNoMapa.get(posicaoNoMapa - 12) == null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 12));
            }
            if (posicoesNoMapa.get(posicaoNoMapa -5) == null && !verificaExtremidade(posicaoNoMapa-5)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 5));
            }
            if (posicoesNoMapa.get(posicaoNoMapa - 7) == null && !verificaExtremidade(posicaoNoMapa)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa - 7));
            }
        }
        else {
            if (posicoesNoMapa.get(posicaoNoMapa + 6) == null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 6));
            }
            if (posicoesNoMapa.get(posicaoNoMapa + 12) == null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 12));
            }
            if (posicoesNoMapa.get(posicaoNoMapa + 5) == null && !verificaExtremidade(posicaoNoMapa+5)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 5));
            }
            if (posicoesNoMapa.get(posicaoNoMapa + 7) == null && !verificaExtremidade(posicaoNoMapa+1)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 7));
            }
        }

        return areaAtaque;
    }
}
