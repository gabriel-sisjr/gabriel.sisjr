package modelsProjetoTC;

/**
 *
 * @author Gabriel Santana
 */
import java.util.ArrayList;


public class Automato {
    ArrayList<Estado> listEstados;
    ArrayList<Transicao> listTransicoes;
    Estado estadoInicial;
    ArrayList<Estado> listEstadosFinais;
    
    public Automato() {
    }

    public Automato(ArrayList<Estado> listEstados, ArrayList<Transicao> listTransicoes, Estado estadoInicial, ArrayList<Estado> listEstadosFinais) {
        this.listEstados = listEstados;
        this.listTransicoes = listTransicoes;
        this.estadoInicial = estadoInicial;
        this.listEstadosFinais = listEstadosFinais;
    }
    
    public boolean isFinal(Estado estado) {
        for (Estado e : listEstadosFinais) {
            if (e.id == estado.id) return true;
        }
        return false;
    }
    
    public void resetar() {
        //reinicializa o automato criando novos objetos vazios
        listEstados = new ArrayList<>();
        estadoInicial = new Estado();
        listEstadosFinais = new ArrayList<>();
    }

}
