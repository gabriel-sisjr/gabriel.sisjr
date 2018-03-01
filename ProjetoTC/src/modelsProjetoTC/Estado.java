package modelsProjetoTC;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Santana
 */
public class Estado {
    int id;
    public String nome;
    
    public Estado(){
        
    }

    public Estado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static Estado retornaEstado(ArrayList<Estado> listaEstados, String nomeEstado){
        for (Estado e : listaEstados) {
            if(e.nome.equals(nomeEstado)) return e;
        }
        return null;
    }
}
