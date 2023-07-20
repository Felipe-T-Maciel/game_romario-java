import java.util.ArrayList;

abstract public class Unidade {

     private int vida, danoAtaque;
     String nome;
     Posicao posicao;
     private ArrayList<Posicao> areaDefesa = new ArrayList<>();
     ArrayList<Posicao> possiveisPosicoes = new ArrayList<>();
     ArrayList<Posicao> areaAtaque = new ArrayList<>();

    public Unidade(
            int vida, int danoAtaque, String nome
    ){
        this.vida = vida;
        this.danoAtaque = danoAtaque;
        this.nome = nome;
    }

    public void pecaMorta(Unidade peca, Jogador jogadorInimigo, Mapa mapa){
        if(peca.getVida() <= 0){
            jogadorInimigo.pecas.remove(peca);
            mapa.getPosicoes().get(mapa.getPosicaoPeca(peca)).setUnidade(null);
        }
    }

    abstract void Atacar(Unidade pecaAtacar, Jogador jogadorInimigo, Mapa mapa);
    abstract ArrayList<Posicao> possiveismovimentos(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca);
    abstract ArrayList<Posicao> VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador, Unidade peca);
    abstract String icon();

    public Posicao getPosicao() {
        return posicao;
    }

    public boolean verificaExtremidade(int posicaoNoMapa){
        return (posicaoNoMapa) % 6 == 0;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void mover(Mapa mapa, Unidade peca, int movimento){
        mapa.posicoes.get(mapa.getPosicaoPeca(peca)).setUnidade(null);
        mapa.posicoes.get(movimento).setUnidade(peca);
    }
}

