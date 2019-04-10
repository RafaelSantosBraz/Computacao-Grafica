/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

import pkg4vizinhaca.Coordenada;

/**
 *
 * @author rafael
 */
public class CoordenadaPeso extends Coordenada {

    private final double peso;

    public CoordenadaPeso(int x, int y, double peso) {
        super(x, y);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

}
