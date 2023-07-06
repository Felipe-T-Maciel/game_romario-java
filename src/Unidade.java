import java.util.ArrayList;

abstract public class Unidade {

     private int vida, danoAtaque;
     String nome;
     Posicao posicao;
     ArrayList<Posicao> possiveisPosicoes = new ArrayList<>();
     ArrayList<Posicao> areaAtaque = new ArrayList<>();

    public Unidade(
            int vida, int danoAtaque, String nome
    ){
        this.vida = vida;
        this.danoAtaque = danoAtaque;
        this.nome = nome;
    }

    abstract void Atacar(Unidade pecaAtacar);
    abstract ArrayList<Posicao> possiveismovimentos(Mapa mapa, Jogador jogandoAgora, Jogador jogador);
    abstract ArrayList<Posicao> VerificaAreaAtaque(Mapa mapa, Jogador jogandoAgora, Jogador jogador);

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

    public boolean mover(Mapa mapa, Posicao posicao){
        for (Posicao posicaoPossivel:
             possiveisPosicoes) {
            if(posicaoPossivel == posicao){
                posicao.setUnidade(this);
                this.posicao.setUnidade(null);
                this.posicao = posicao;

                return true;
            }
        }
        return false;
    }
}

