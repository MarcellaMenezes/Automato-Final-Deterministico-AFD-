package automatolista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class Automato {
    private String setenca, estadoInicial;
    private List<String>  estadosFinais;
    private List<Transicao> listaTransicao;

    public Automato(String setenca, String estadoInicial, List<String> estadosFinais, List<Transicao> listaTransicao) {
        this.setenca = null;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.listaTransicao = listaTransicao;
    }

    public String getSetenca() {
        return setenca;
    }

    public void setSetenca(String setenca) {
        this.setenca = setenca;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public List<String> getEstadosFinais() {
        return estadosFinais;
    }

    public List<Transicao> getListaTransicao() {
        return listaTransicao;
    }
    
    public void imprimeEstadoInicial(){
        System.out.println("Estado Inicial = "+estadoInicial);    
    }
    
    public void imprimeEstadosFinais(){
        System.out.print("Estados Finais = ");
        for (String s : estadosFinais) { System.out.print("" +s+" ");
        } 
    }
    
    public void imprimeListaTransicao(){
        System.out.println("\n\nLista Transicao:");
        for(Transicao t:listaTransicao){
            t.imprimeTransicao();
        }
    }
    
    public void pedeSetenca(){
        Scanner inputPalavra = new Scanner(System.in);
        System.out.println("\nInforme uma palavra:");
        setSetenca(inputPalavra.next());
    }
    
    public String retornaEstadoDestino(String origem, char c){ //
        for(Transicao t:listaTransicao){
            if(t.getEstadoOrigem().equals(origem) && t.getLetraSetenca()==c)
                return t.getEstadoDestino();
        }
        return null;
    }
    
    public Boolean isFinal(String estado){ 
        for(String finalEstado: estadosFinais){ //recebe cada string da lista que é um estado final
            if(finalEstado.equals(estado)) return true; //verifica se o estado pertenca a lista
        }
        return false;
    }
    
    public Boolean verificaSetenca(){
        String estadoAtual= estadoInicial, proximoEstado; 
        
        for(int i=0; i<setenca.length();i++){ //for que percorre o tamanho da sentença
            char letra =setenca.charAt(i); //pega letra por letra da sentença de entrada
            proximoEstado = retornaEstadoDestino(estadoAtual, letra);
            if(proximoEstado==null) return false; //se nao existe saida daquele estado, consumindo aquela letra
            estadoAtual=proximoEstado; //o estado atual recebe o proximo estado
        }
        return isFinal(estadoAtual); //chama o metodo pra conferir se o estado que parou pertence a lista de estados finais
    }   
}
