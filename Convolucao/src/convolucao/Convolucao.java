/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

import java.util.ArrayList;
import java.util.HashMap;
import pkg4vizinhaca.Coordenada;
import pkg4vizinhaca.Imagem;
import pkg4vizinhaca.RGB;

/**
 *
 * @author aluno
 */
public class Convolucao {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;
    private final double[][] mascara;

    public Convolucao(Imagem imgSrc, double[][] mascara) {
        this.imgSrc = imgSrc;
        this.mascara = mascara;
    }

    public void aplicarConvolucao() {
        imgOut = new HashMap<>();
        for (int x = 0; x < imgSrc.getLargura(); x++) {
            for (int y = 0; y < imgSrc.getAltura(); y++) {
                Coordenada xy = new Coordenada(x, y);
                ArrayList<RGB> vizinhos = getListaPixels(xy);
                //vizinhos.addAll(getListaPixelsDiagonal(xy));
                //RGB novo = calcularMediapixels(vizinhos);
                //imgOut.put(xy, novo);
            }
        }
    }

    private ArrayList<RGB> getListaPixels(Coordenada xy) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        ArrayList<Coordenada> coords = new ArrayList<>();
        coords.add(new Coordenada(xy.getX() - 1, xy.getY()));
        coords.add(new Coordenada(xy.getX() + 1, xy.getY()));
        coords.add(new Coordenada(xy.getX(), xy.getY() + 1));
        coords.add(new Coordenada(xy.getX(), xy.getY() - 1));
        vizinhos.addAll(getListaBase(coords));
        return vizinhos;
    }
}
