/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotc;

/**
 *
 * @author Daniel Lima Oliveira
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
