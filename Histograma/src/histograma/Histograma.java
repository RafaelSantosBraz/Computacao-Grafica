/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

import java.util.HashMap;

/**
 *
 * @author Rafael Braz
 */
public class Histograma {

    private final HashMap<Integer, Integer> histograma;

    public Histograma() {
        histograma = new HashMap<>();
    }

    public Integer getValor(Integer pos) {
        return histograma.get(pos);
    }

    public void setValor(Integer pos) {
        if (getValor(pos) != null) {
            histograma.put(pos, getValor(pos) + 1);
        } else {
            histograma.put(pos, 1);
        }
    }
    
    public void exibirValores(){
        histograma.forEach((t, u) -> {
            System.out.println("Valor " + t + " Quant " + u);
        });
    }
    
    public void exibirGrafico(){
        
    }
}
