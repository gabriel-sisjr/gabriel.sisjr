package modelsProjetoTC;

/**
 *
 * @author Gabriel Santana
 */
import javax.swing.JOptionPane;

public class Home {
    
    public static void main(String[] args) {
        Automato a = Arquivo.gerarAutomato2();
        String palavra = "-";
        while (!(palavra = JOptionPane.showInputDialog(null, "Digite a palavra a ser validada:")).equals("")) {
            Processador p = new Processador(a,palavra);            
            p.processaPalavra();
            JOptionPane.showMessageDialog(null, p.resultado);
        }
    }
}
