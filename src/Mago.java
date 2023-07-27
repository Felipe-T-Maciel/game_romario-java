import java.util.ArrayList;

public class Mago extends Unidade{
    public Mago(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    Jogador jogador1;


    @Override
    void Atacar(Unidade pecaAtacar, Jogador jogadorInimigo, Mapa mapa) {
        int vida = pecaAtacar.getVida();
        vida -= 35;
        pecaAtacar.setVida(vida);
        pecaMorta(pecaAtacar, jogadorInimigo, mapa);
    }

    @Override
    ArrayList possiveismovimentos(Mapa mapa,Jogador jogandoAgora, Jogador jogador,Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();
        possiveisPosicoes.removeAll(posicoesNoMapa);

            if(posicaoNoMapa-6>0){
                if(posicoesNoMapa.get(posicaoNoMapa-6).getUnidade() == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
                }
            }
            if(posicaoNoMapa+6<36){
                if(posicoesNoMapa.get(posicaoNoMapa+6).getUnidade()  == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
                }
            }
            if(posicaoNoMapa-1>0){
                if(posicoesNoMapa.get(posicaoNoMapa+1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa+1)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
                }
            }
            if(posicaoNoMapa+1<36){
                if(posicoesNoMapa.get(posicaoNoMapa-1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
                }
            }

            if(posicaoNoMapa+6<36){
                if(posicoesNoMapa.get(posicaoNoMapa+6).getUnidade()  == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+6));
                }
            }
            if(posicaoNoMapa-6 >= 0){
                if(posicoesNoMapa.get(posicaoNoMapa-6).getUnidade()  == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-6));
                }
            }
            if(posicaoNoMapa-1 >= 0){
                if(posicoesNoMapa.get(posicaoNoMapa-1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
                }
            }
            if(posicaoNoMapa+1<36){
                if(posicoesNoMapa.get(posicaoNoMapa+1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa+1)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
                }
            }


        return possiveisPosicoes;
    }

    @Override
    ArrayList VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        areaAtaque.removeAll(posicoesNoMapa);

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

                if(j>=0){
                    if(posicoesNoMapa.get(j).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(j));
                    }
                }

                j-=5;

            }while (j>=0 && !verificaExtremidade(j));

            int l = posicaoNoMapa;
            do{

                if(l<36){
                    if(posicoesNoMapa.get(l).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(l));
                    }
                }

                l+=7;

            }while (l<36 && !verificaExtremidade(l+1));


            int f = posicaoNoMapa;

            do{

                f+=5;

                if(f<36){
                    if(posicoesNoMapa.get(f).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(f));
                    }
                }

            }while (f<36 && !verificaExtremidade(f));

        return areaAtaque;
    }

    @Override
    String icon() {
        return "Ma";
    }


}
