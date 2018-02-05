package projetotc;

import java.util.ArrayList;

public class Processador {
    
    static int cont = 0;
    static boolean resultado = false;
    
    Automato automato;
    Estado estadoAtual;
    String palavraAtual;

    public Processador(Automato automato, String palavraAtual) {
        this.automato = automato;
        this.estadoAtual = automato.estadoInicial;
        this.palavraAtual = palavraAtual;
        cont++;
    }
    
    public Processador(Automato automato, Estado estadoAtual, String palavraAtual) {
        this.automato = automato;
        this.estadoAtual = estadoAtual;
        this.palavraAtual = palavraAtual;
        cont++;
    }
    
    void processaPalavra(){
        resultado = false;
        valida();
    }
    
    void valida() {
        
        if (palavraAtual.equals("")) {
            if (automato.isFinal(estadoAtual))
                resultado = true;
            return;
        }
        
        char charAtual = palavraAtual.charAt(0);
        ArrayList<Estado> listProximosEstados = proximasTransicoes(charAtual);
        
        for (Estado e : listProximosEstados) {
            if (cont > 50000) return;
            else new Processador(automato, e ,removeChar(palavraAtual)).valida();
        }
    }
    
    ArrayList<Estado> proximasTransicoes(char c){
        ArrayList<Estado> estados = new ArrayList<>();
        for (Transicao t : automato.listTransicoes) {
            if (t.origem.id == estadoAtual.id && t.consumo == c) estados.add(t.destino);
            if (t.origem.id == estadoAtual.id && t.consumo == '$') estados.add(t.destino);
        }
        return estados;
    }
    
    public String removeChar(String s) {
        try {
            return palavraAtual.substring(1);
        } catch (Exception ex) {
            return "";
        }
    }
}
