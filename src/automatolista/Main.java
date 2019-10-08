package automatolista;

/**
 *
 * @author marcella
 */
public class Main {


    public static void main(String[] args) {
        Automato automato = Arquivo.lerEGravarAutomato();
        automato.imprimeEstadoInicial();
        automato.imprimeEstadosFinais();
        automato.imprimeListaTransicao();
        automato.pedeSetenca();
        System.out.println(automato.verificaSetenca());
    }
    
}
