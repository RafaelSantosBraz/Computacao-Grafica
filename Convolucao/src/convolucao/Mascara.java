/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

import java.util.ArrayList;
import pkg4vizinhaca.Coordenada;

/**
 *
 * @author Rafael Braz
 */
public class Mascara {

    private final double[][] masc;

    public Mascara(double[][] masc) {
        this.masc = masc;
    }

    public Mascara(double[][] masc, double fracao) {
        this.masc = masc;
        aplicarFracao(fracao);
    }

    private void aplicarFracao(double fracao) {
        for (double[] masc1 : masc) {
            for (int i = 0; i < masc1.length; i++) {
                masc1[i] *= fracao;
            }
        }
    }

    public boolean verificarMascara() {
        int count = masc.length;
        for (double[] masc1 : masc) {
            if (masc1.length != count) {
                return false;
            }
        }
        return count % 2 != 0;
    }

    public ArrayList<CoordenadaPeso> getCoordenadasRelativas(Coordenada xy) {
        return criarCoordenadas(xy);
    }

    private Coordenada getCoordMeio() {
        int c = masc.length / 2;
        return new Coordenada(c, c);
    }

    private ArrayList<CoordenadaPeso> criarCoordenadas(Coordenada xy) {
        ArrayList<CoordenadaPeso> coords = new ArrayList<>();
        Coordenada meio = getCoordMeio();
        for (int n = 0; n < masc.length; n++) {
            for (int m = 0; m < masc.length; m++) {
                if (masc[n][m] != 0.0) {
                    int novoX, novoY, distX, distY;
                    distX = meio.getX() - n;
                    if (distX > 0) {
                        novoX = xy.getX() - distX;
                    } else {
                        novoX = xy.getX() + distX;
                    }
                    distY = meio.getY() - m;
                    if (distY > 0) {
                        novoY = xy.getY() - distY;
                    } else {
                        novoY = xy.getY() + distY;
                    }
                    coords.add(new CoordenadaPeso(novoX, novoY, masc[n][m]));
                }
            }
        }
        return coords;
    }

    public double getPeso(Coordenada coord) {
        return masc[coord.getX()][coord.getY()];
    }
}
