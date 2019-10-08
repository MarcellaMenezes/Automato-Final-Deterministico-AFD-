package automatolista;

/**
 *
 * @author marcella menezes
 */
public class Main {


    public static void main(String[] args) {
        Automato automato = Arquivo.lerEGravarAutomato();
        automato.imprimeEstadoInicial();
        automato.imprimeEstadosFinais();
        automato.imprimeListaTransicao();
        automato.pedeSentenca();
        System.out.println(automato.verificaSetenca());
    }
    
}
