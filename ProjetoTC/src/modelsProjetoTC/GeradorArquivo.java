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
      public static void gerarArquivo(Automato automato, String nomeArquivo)throws IOException{
        
        // Criando o arquivo que será lido pelo JFlap.
        File arquivo = new File("arquivosExportados/"+nomeArquivo+".jff");
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter caneta = new BufferedWriter(escritor);
        
        // Começando o arquivo para ser lido no JFLAP.
        caneta.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Criado no projeto de TC - Gabriel Santana 2018. --><structure>\n\t<type>fa</type> \n\t<automaton>");
        // Para cada estado
        for(Estado estados : automato.listEstados){
            // Verificando se é estado Inicial e Final ao mesmo tempo.
            if(estados.getId() == automato.getEstadoInicial().getId() && automato.listEstadosFinais.contains(estados))
                caneta.write("\n\t\t<state id=\"" + automato.estadoInicial.getId() + "\" name=\"" + automato.estadoInicial.getNome() + "\">\n\t\t\t<initial/>\n\t\t<final/>\n\t\t</state>");
            // Verificando se é apenas Inicial.
            else if(!(automato.listEstadosFinais.contains(estados)) && estados.getId() == automato.getEstadoInicial().getId())
                caneta.write("\n\t\t<state id=\"" + automato.estadoInicial.getId() + "\" name=\"" + automato.estadoInicial.getNome() + "\">\n\t\t\t<initial/>\n\t\t</state>");
            
            
            // Escrevendo os estados Finais que não são estados iniciais.
            if(automato.listEstadosFinais.contains(estados) && estados.getId() != automato.getEstadoInicial().getId())
                caneta.write("\n\t\t<state id=\"" + estados.getId() + "\" name=\"" + estados.getNome() + "\"> \n\t\t\t<final/>\n\t\t</state>");
            
            // Escrevendo os demais estados.
            if(automato.listEstados.contains(estados) && !(automato.listEstadosFinais.contains(estados)) && estados.getId() != automato.getEstadoInicial().getId())
                caneta.write("\n\t\t<state id=\"" + estados.getId() + "\" name=\"" + estados.getNome() + "\"> \n\t\t</state>");
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