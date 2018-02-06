package modelsProjetoTC;

/**
 *
 * @author Gabriel Santana
 */
import java.util.ArrayList;

public class Arquivo {
    
    public Arquivo() {
        
    }
    
    static public Automato gerarAutomato1() {
        ArrayList<Estado> listEstados = new ArrayList<>();
        ArrayList<Transicao> listTransicoes = new ArrayList<>();
        ArrayList<Estado> listEstadoFinal = new ArrayList<>();
        
        Estado q0 = new Estado(1,"q0");
        Estado q1 = new Estado(2,"q1");
        Estado q2 = new Estado(3,"q2");
        listEstados.add(q0);
        listEstados.add(q1);
        listEstados.add(q2);
        listEstadoFinal.add(q2);
        
        Transicao t0 = new Transicao(q0, q1, 'a');
        Transicao t1 = new Transicao(q1, q1, 'a');
        Transicao t2 = new Transicao(q1, q1, 'b');
        Transicao t3 = new Transicao(q1, q2, 'a');
        listTransicoes.add(t0);
        listTransicoes.add(t1);
        listTransicoes.add(t2);
        listTransicoes.add(t3);
        
        return new Automato(listEstados, listTransicoes, q0, listEstadoFinal);
    }
    
    static public Automato gerarAutomato2() {
        ArrayList<Estado> listEstados = new ArrayList<>();
        ArrayList<Transicao> listTransicoes = new ArrayList<>();
        ArrayList<Estado> listEstadoFinal = new ArrayList<>();
        
        Estado q0 = new Estado(1,"q0");
        Estado q1 = new Estado(2,"q1");
        listEstados.add(q0);
        listEstados.add(q1);
        listEstadoFinal.add(q1);
                
        Transicao t0 = new Transicao(q0, q0, '0');
        Transicao t1 = new Transicao(q0, q0, '1');
        Transicao t2 = new Transicao(q0, q1, '1');
        Transicao t3 = new Transicao(q1, q1, '0');
        listTransicoes.add(t0);
        listTransicoes.add(t1);
        listTransicoes.add(t2);
        listTransicoes.add(t3);
        
        return new Automato(listEstados, listTransicoes, q0, listEstadoFinal);
    }
    
}
