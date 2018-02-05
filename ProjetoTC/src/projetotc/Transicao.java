package projetotc;

/**
 *
 * @author Gabriel Santana
 */
public class Transicao {
    Estado origem;
    Estado destino;
    char consumo;

    public Transicao(Estado origem, Estado destino, char consumo) {
        this.origem = origem;
        this.destino = destino;
        this.consumo = consumo;
    }
    
}
