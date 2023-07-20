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
        if(jogandoAgora == jogador){

            int i = posicaoNoMapa;

            do{
                i-=7;
                if(i>=0){
                    if(posicoesNoMapa.get(i).getUnidade() == null){
                        possiveisPosicoes.add(posicoesNoMapa.get(i));
                    }
                }

            }while (i>=0 && !verificaExtremidade(i));



            int j = posicaoNoMapa;

            do{
                j-=5;

                if(j>=0){
                    if(posicoesNoMapa.get(j).getUnidade() == null && !verificaExtremidade(j)){
                        possiveisPosicoes.add(posicoesNoMapa.get(j));
                    }
                }

            }while (j>=0 && !verificaExtremidade(j));

            i = posicaoNoMapa;
            do{

                i+=7;

                if(i<36){
                    if(posicoesNoMapa.get(i).getUnidade() == null){
                        possiveisPosicoes.add(posicoesNoMapa.get(i));
                    }
                }

            }while (i<36 && !verificaExtremidade(i+1));


            j = posicaoNoMapa;

            do{

                j+=5;
                if(j<36){
                    if(posicoesNoMapa.get(j).getUnidade() == null && !verificaExtremidade(j)){
                        possiveisPosicoes.add(posicoesNoMapa.get(j));
                    }
                }



            }while (j<36 && !verificaExtremidade(j));
        }

        return possiveisPosicoes;
    }

    @Override
    ArrayList<Posicao> VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca) {

        int posicaoNoMapa = mapa.getPosicaoPeca(peca);
        ArrayList<Posicao> posicoesNoMapa = mapa.getPosicoes();
        areaAtaque.removeAll(posicoesNoMapa);
        if(jogandoAgora == jogador) {

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

        }
        else {
            if (posicoesNoMapa.get(posicaoNoMapa + 6).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 6));
            }
            if (posicoesNoMapa.get(posicaoNoMapa + 12).getUnidade() != null) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 12));
            }
            if (posicoesNoMapa.get(posicaoNoMapa + 5).getUnidade() != null && !verificaExtremidade(posicaoNoMapa+5)) {
                areaAtaque.add(posicoesNoMapa.get(posicaoNoMapa + 5));
            }
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
