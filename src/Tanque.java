import java.util.ArrayList;

public class     Tanque extends Unidade{
    public Tanque(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    @Override
    void Atacar(Unidade pecaAtacar) {
        int vida = pecaAtacar.getVida();
        vida -= 5;
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

        if(jogandoAgora == jogador){
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+1) == null && !verificaExtremidade(posicaoNoMapa+1)){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+1));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-1) == null && !verificaExtremidade(posicaoNoMapa)){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-1));
            }
        }else {
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null && (posicaoNoMapa+6) < 72){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-1) == null && !verificaExtremidade(posicaoNoMapa)){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-1));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+1) == null && !verificaExtremidade(posicaoNoMapa+1)){
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+1));
            }
        }

        return areaAtaque;
    }

    @Override
    String icon() {
        return "Ta";
    }

    public ArrayList<Posicao> areaDefesaTanque(Mapa mapa, Jogador jogandoAgora, Jogador jogador){
        ArrayList<Posicao> areaDefesa = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoMapa = mapa.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        for (int i = posicaoNoMapa; i < 72; i++) {

            if(posicoesNoMapa.get(posicaoNoMapa+5) != null && !verificaExtremidade(posicaoNoMapa)){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa+5));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+6) != null){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+7) != null && !verificaExtremidade(posicaoNoMapa-5)){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa+7));
            }
        }

        for (int i = posicaoNoMapa; i > 0; i--) {

            if(posicoesNoMapa.get(posicaoNoMapa-5) != null && !verificaExtremidade(posicaoNoMapa-5)){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa-5));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-6) != null){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa-6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-7) != null && !verificaExtremidade(posicaoNoMapa)){
                areaDefesa.add(posicoesNoMapa.get(posicaoNoMapa-7));
            }
        }

        return areaDefesa;
    }
}
