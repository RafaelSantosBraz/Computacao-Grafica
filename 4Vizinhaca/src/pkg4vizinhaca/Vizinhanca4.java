/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4vizinhaca;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael Braz
 */
public class Vizinhanca4 {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;

    public Vizinhanca4(Imagem imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void calcular4VizinhancaHorVert() {
        calcular4Vizinhanca(false);
    }

    public void calcular4VizinhancaDiagonal() {
        calcular4Vizinhanca(true);
    }

    private void calcular4Vizinhanca(boolean diagonal) {
        imgOut = new HashMap<>();
        for (int x = 0; x < imgSrc.getLargura(); x++) {
            for (int y = 0; y < imgSrc.getAltura(); y++) {
                Coordenada xy = new Coordenada(x, y);
                ArrayList<RGB> vizinhos;
                if (diagonal) {
                    vizinhos = getListaPixelsDiagonal(xy);
                } else {
                    vizinhos = getListaPixels(xy);
                }
                RGB novo = calcularMediapixels(vizinhos);
                imgOut.put(xy, novo);
            }
        }
    }

    private RGB calcularMediapixels(ArrayList<RGB> vizinhos) {
        RGB novo = new RGB(0, 0, 0);
        vizinhos.forEach((t) -> {
            novo.incrementarRGB(t);
        });
        calcularMediaRGB(novo, vizinhos.size());
        return novo;
    }

    private void calcularMediaRGB(RGB p, int quant) {
        p.setR(p.getR() / quant);
        p.setG(p.getG() / quant);
        p.setB(p.getB() / quant);
    }

    private ArrayList<RGB> getListaPixels(Coordenada xy) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        vizinhos.add(compensarRGB(xy));
        ArrayList<Coordenada> coords = new ArrayList<>();
        coords.add(new Coordenada(xy.getX() - 1, xy.getY()));
        coords.add(new Coordenada(xy.getX() + 1, xy.getY()));
        coords.add(new Coordenada(xy.getX(), xy.getY() + 1));
        coords.add(new Coordenada(xy.getX(), xy.getY() - 1));
        vizinhos.addAll(getListaBase(coords));
        return vizinhos;
    }

    private ArrayList<RGB> getListaPixelsDiagonal(Coordenada xy) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        vizinhos.add(compensarRGB(xy));
        ArrayList<Coordenada> coords = new ArrayList<>();
        coords.add(new Coordenada(xy.getX() - 1, xy.getY() - 1));
        coords.add(new Coordenada(xy.getX() + 1, xy.getY() - 1));
        coords.add(new Coordenada(xy.getX() - 1, xy.getY() + 1));
        coords.add(new Coordenada(xy.getX() + 1, xy.getY() + 1));
        vizinhos.addAll(getListaBase(coords));
        return vizinhos;
    }

    private RGB compensarRGB(Coordenada xy) {
        RGB novo = new RGB(0, 0, 0);
        RGB p = imgSrc.getRGB(xy);
        novo.incrementarRGB(p);
        return novo;
    }

    private ArrayList<RGB> getListaBase(ArrayList<Coordenada> coords) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        coords.forEach((t) -> {
            RGB pxy = imgSrc.getRGB(t);
            if (pxy != null) {
                vizinhos.add(pxy);
            }
        });
        return vizinhos;
    }

    public void gerarImagemSaida(String caminho) throws IOException {
        BufferedImage saida = new BufferedImage(imgSrc.getLargura(), imgSrc.getAltura(), imgSrc.getTipo());
        imgOut.forEach((t, u) -> {
            saida.setRGB(t.getX(), t.getY(), new Color(u.getR(), u.getG(), u.getB()).getRGB());
        });
        File out = new File(caminho);
        ImageIO.write(saida, "JPG", out);
    }
}
