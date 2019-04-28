/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiarizacao;

import histograma.ChaveValor;
import histograma.Histograma;

/**
 *
 * @author rafael
 */
public class LimiarProbabilidade extends Otsu {

    public LimiarProbabilidade(Histograma histograma) {
        super(histograma);
    }

    public int calcularProbabilidade() {
        ChaveValor maiorChaveValor = P.getMaiorChaveValor();
        //System.out.println(maiorChaveValor.getChave() + " " + maiorChaveValor.getValor());        
        return maiorChaveValor.getChave();
    }
}
