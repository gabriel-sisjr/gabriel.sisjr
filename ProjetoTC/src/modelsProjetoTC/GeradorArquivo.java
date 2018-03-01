/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsProjetoTC;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class GeradorArquivo {
    
    // Metodos para gerar o arquivo
      public static void gerarArquivo(Automato automato)throws IOException{
        
        // Criando o arquivo que será lido pelo JFlap.
        File arquivo = new File("arquivosExportados/VisualizarEstados.jff");
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter caneta = new BufferedWriter(escritor);
        caneta.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Created with JFLAP 6.4.--><structure>\n\t<type>fa</type> \n\t<automaton>");
        
        // Escrevendo o estado inicial
        caneta.write("\n\t\t<state id=\"" + automato.estadoInicial.getId() + "\" name=\"" + automato.estadoInicial.getNome() + "\">\n\t\t\t<initial/>\n\t\t</state>");
        
        // Escrevendo os estados.
        for(Estado estados : automato.listEstados){
            // Escrevendo os estados Finais.
            if(automato.listEstadosFinais.contains(estados)){
                caneta.write("\n\t\t<state id=\"" + estados.getId() + "\" name=\"" + estados.getNome() + "\"> \n\t\t\t<final/>\n\t\t</state>");
            }
            if(automato.listEstados.contains(estados) && !(automato.listEstadosFinais.contains(estados)) && estados.getId() != automato.getEstadoInicial().getId()){
                caneta.write("\n\t\t<state id=\"" + estados.getId() + "\" name=\"" + estados.getNome() + "\"> \n\t\t</state>");
            }
        }
        
        // Escrevendo as transições
        for(Transicao transicao : automato.listTransicoes){
            caneta.write("\n\t\t<transition>");
            caneta.write("\n\t\t\t<from>" + transicao.origem.getNome().charAt(1)+ "</from>");
            caneta.write("\n\t\t\t<to>" + transicao.destino.getNome().charAt(1) + "</to>");
            caneta.write("\n\t\t\t<read>" + transicao.consumo + "</read>");
            caneta.write("\n\t\t</transition>");
        }
        
        // Fechando a estrutura do arquivo.
        caneta.write("\n\t</automaton>\n</structure>");
        // Fechando a stream do arquivo propriamente dito.
        caneta.close();
      }
}