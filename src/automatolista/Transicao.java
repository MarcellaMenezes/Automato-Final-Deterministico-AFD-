package automatolista;

/**
 *
 * @author marcella menezes
 */
public class Transicao {
    private String estadoOrigem, estadoDestino;
    char letraSetenca;

    public Transicao(String estadoOrigem, char letraSetenca, String estadoDestino) { 
        this.estadoOrigem = estadoOrigem;
        this.estadoDestino = estadoDestino;
        this.letraSetenca = letraSetenca;
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }
    
    public char getLetraSetenca() {
        return letraSetenca;
    }

    public void setLetraSetenca(char letraSetenca) {
        this.letraSetenca = letraSetenca;
    }
    
    public void imprimeTransicao(){ //toString
        System.out.println("σ("+estadoOrigem+", "+letraSetenca+") = "+estadoDestino);
    }
    
}
