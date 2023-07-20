import java.util.ArrayList;

public class Arqueiro extends Unidade{
    public Arqueiro(int vida, int danoAtaque, String nome) {
        super(vida, danoAtaque, nome);
    }

    @Override
    void Atacar(Unidade pecaAtacar, Jogador jogadorInimigo, Mapa mapa) {
        int vida = pecaAtacar.getVida();
        vida -= 15;
        pecaAtacar.setVida(vida);
        pecaMorta(pecaAtacar, jogadorInimigo, mapa);
    }

    @Override
    ArrayList possiveismovimentos(Mapa mapa, Jogador jogandoAgora, Jogador jogador1, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        possiveisPosicoes.removeAll(posicoesNoMapa);

        if(jogandoAgora == jogador1){

            int i = posicaoNoMapa;
            do{
                i-=6;

                if(i>=0){
                    if(posicoesNoMapa.get(i).getUnidade() == null){
                        possiveisPosicoes.add(posicoesNoMapa.get(i));
                    }
                }

            }while (i>=0);

            int j = posicaoNoMapa;
            do{

                if(posicoesNoMapa.get(j).getUnidade() == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(j));
                }

                j+=6;

            }while (j<36);

            if(posicaoNoMapa+1<36){
                if(posicoesNoMapa.get(posicaoNoMapa+1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa+1)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
                }
            }

            if(posicaoNoMapa-1>=0){
                if(posicoesNoMapa.get(posicaoNoMapa-1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
                }
            }


        }else {

            int i = posicaoNoMapa;
            do{
                i-=6;

                if(i>=0){
                    if(posicoesNoMapa.get(i).getUnidade() == null){
                        possiveisPosicoes.add(posicoesNoMapa.get(i));
                    }
                }

            }while (i>=0);

            int j = posicaoNoMapa;
            do{

                if(posicoesNoMapa.get(j).getUnidade() == null){
                    possiveisPosicoes.add(posicoesNoMapa.get(j));
                }

                j+=6;

            }while (j<36);

            if(posicaoNoMapa-1>=0){
                if(posicoesNoMapa.get(posicaoNoMapa-1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa-1));
                }
            }
            if(posicaoNoMapa+1<36){
                if(posicoesNoMapa.get(posicaoNoMapa+1).getUnidade()  == null && !verificaExtremidade(posicaoNoMapa+1)){
                    possiveisPosicoes.add(posicoesNoMapa.get(posicaoNoMapa+1));
                }
            }

        }


        return possiveisPosicoes;
    }

    @Override
    ArrayList VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();

        areaAtaque.removeAll(posicoesNoMapa);
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

            int l = posicaoNoMapa;

            do{

                if(l>=0){
                    if(posicoesNoMapa.get(l).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(l));
                    }
                }

                l-=6;

            }while (l>=0);


            int j = posicaoNoMapa;

            do{

                if(j>=0){
                    if(posicoesNoMapa.get(j).getUnidade() != null && !verificaExtremidade(j)){
                        areaAtaque.add(posicoesNoMapa.get(j));
                    }
                }

                j-=5;

            }while (j>=0 && !verificaExtremidade(j));

        }else{
            int i = posicaoNoMapa;
            int l = posicaoNoMapa;

            do{

                if(l<36){
                    if(posicoesNoMapa.get(l).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(l));
                    }
                }

                l+=6;

            }while (l<36);

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

                if(j < 36){
                    if(posicoesNoMapa.get(j).getUnidade() != null){
                        areaAtaque.add(posicoesNoMapa.get(j));
                    }
                }

            }while (j<36 && !verificaExtremidade(j));
        }

        return areaAtaque;
    }

    @Override
    String icon() {
        return "Ar";
    }
}
