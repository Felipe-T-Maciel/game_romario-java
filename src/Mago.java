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
            if(posicoesNoMapa.get(posicaoNoMapa+6) == null){
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
            if(posicoesNoMapa.get(posicaoNoMapa-6) == null){
                possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
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
    ArrayList VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();


        if(jogandoAgora == jogador){

            int i = posicaoNoMapa;

            do{
                i-=7;

                if(i>=0){
                    if(posicoesNoMapa.get(i).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(i));
                    }
                }

            }while (i>=0 && !verificaExtremidade(i));


            int j = posicaoNoMapa;

            do{

                if(posicoesNoMapa.get(j).getUnidade() != null && !verificaExtremidade(j)){
                    areaAtaque.add(posicoesNoMapa.get(j));
                }

                j-=5;

            }while (j>=0 && !verificaExtremidade(j));
        }else{
            int i = posicaoNoMapa;
            do{

                if(i<36){
                    if(posicoesNoMapa.get(i).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(i));
                    }
                }

                i+=7;

            }while (i<36 && !verificaExtremidade(i+1));


            int j = posicaoNoMapa;

            do{

                j+=5;

                if(posicoesNoMapa.get(j).getUnidade() != null && !verificaExtremidade(j)){
                    areaAtaque.add(posicoesNoMapa.get(j));
                }

            }while (j<36 && !verificaExtremidade(j));
        }

        return areaAtaque;
    }

    @Override
    String icon() {
        return "Ma";
    }


}
