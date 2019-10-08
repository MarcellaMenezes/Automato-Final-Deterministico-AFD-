/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatolista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Arquivo {

    public static Automato lerEGravarAutomato() {
        String estadoInicial, estadosFinais, linhaTransicao;

        try {
            FileReader arq = new FileReader("transicao.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            
            estadoInicial = lerArq.readLine(); //primeira linha = estadoInicial
            estadosFinais = lerArq.readLine(); //segunda linha = estadoFinal, mas pode ter mais de um estado final
 
            String [] vetEstadosFinais; // crio um vetor de estados finais
            vetEstadosFinais= estadosFinais.split(";"); //separa os estados finais por ;
            List <String>listEstadosFinais = new ArrayList<String>(); //cria lista de estados finais
            
            for(int i=0;i<vetEstadosFinais.length;i++){   //pega o tamanho do vetor de estados finais pra percorrer
                listEstadosFinais.add(vetEstadosFinais[i]); //vai adicionando um por um do vetor na lista 
            }
            
            linhaTransicao = lerArq.readLine(); //depois das duas linhas no txt começa as transições
            List <Transicao> listTransicao = new ArrayList<Transicao>(); //cria a lista de transição  
            
            for(int i=0;linhaTransicao != null;i++) { //roda enquanto tiver escrito no arquivo
                String transicao[] = linhaTransicao.split(";");
                Transicao transicaoLida= new Transicao(transicao[0],transicao[1].charAt(0), transicao[2]); //cada linha eh um objeto com estadoOrigem, char, estadoDestino
                listTransicao.add(transicaoLida); //cada objeto eh adicionado da lista de transicao
                
                linhaTransicao = lerArq.readLine(); //p ler a proxima linha, no for
            } 
            arq.close(); //se a linha = null, fecha o arquivo
            
            return new Automato(null, estadoInicial, listEstadosFinais, listTransicao); //automato (sentença, estadoInicial, lista dos estados finais e a lista de transição)
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }
    }
    
}
