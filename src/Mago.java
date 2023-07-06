import java.util.ArrayList;

public class Mago extends Unidade{
    public Mago(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    Jogador jogador1;


    @Override
    void Atacar(Unidade pecaAtacar) {
        int vida = pecaAtacar.getVida();
        vida -= 35;
        pecaAtacar.setVida(vida);
    }

    @Override
    ArrayList possiveismovimentos(Mapa mapa,Jogador jogandoAgora, Jogador jogador) {

        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoMapa = mapa.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        if(jogandoAgora == jogador1){
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null && (posicaoNoMapa+6) < 72){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa+1) == null && !verificaExtremidade(posicaoNoMapa+1)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-1) == null && !verificaExtremidade(posicaoNoMapa)){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
            }
        }else {
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
            }
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null && (posicaoNoMapa-6) < 72){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+8));
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
    ArrayList VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador) {

        Posicao posicaoAtual = this.getPosicao();
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();
        int posicaoNoMapa = mapa.getPosicoes().indexOf(posicaoAtual);

        int i=5;
        int j=7;
        int z=6;

        if(jogandoAgora == jogador1){
            while(posicoesNoMapa.get(posicaoNoMapa-i) == null && !verificaExtremidade((posicaoNoMapa-i)+1)){
                i += 5;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-i));
            }

            while(posicoesNoMapa.get(posicaoNoMapa-j) == null && !verificaExtremidade(posicaoNoMapa-j)){
                j += 7;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-j));
            }

            while(posicoesNoMapa.get(posicaoNoMapa-z) == null){
                z += 6;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa-z));
            }
        }
        else {
            while(posicoesNoMapa.get(posicaoNoMapa+i) == null && !verificaExtremidade(posicaoNoMapa+i)){
                i += 5;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+i));
            }

            while(posicoesNoMapa.get(posicaoNoMapa+j) == null && !verificaExtremidade((posicaoNoMapa+j)+1)){
                j += 7;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+j));
            }

            while(posicoesNoMapa.get(posicaoNoMapa+z) == null){
                z += 6;
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa+z));
            }
        }

        return areaAtaque;
    }



}