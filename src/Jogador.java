import java.util.ArrayList;

public class Jogador {
    String nome;
    ArrayList<Unidade> pecas;
    Jogador jogandoAgora;
    public Jogador(String nome){
        this.nome = nome;
        pecas = new ArrayList();
    }
}
