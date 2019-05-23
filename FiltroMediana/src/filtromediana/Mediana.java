/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtromediana;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import pkg4vizinhaca.Coordenada;
import pkg4vizinhaca.Imagem;
import pkg4vizinhaca.RGB;

/**
 *
 * @author Rafael Braz
 */
public class Mediana {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;
    private final int tamanhoJanela;

    public Mediana(Imagem imgSrc, int tamanhoJanela) throws Exception {
        this.imgSrc = imgSrc;
        if (tamanhoJanela % 2 != 0) {
            this.tamanhoJanela = tamanhoJanela;
        } else {
            throw new Exception("Janela deve possuir tamanho ímpar!");
        }
    }

    public Imagem getImgSrc() {
        return imgSrc;
    }

    public HashMap<Coordenada, RGB> getImgOut() {
        return imgOut;
    }

    public int getTamanhoJanela() {
        return tamanhoJanela;
    }

    public void mediana() {
        imgOut = new HashMap<>();
        for (int x = 0; x < imgSrc.getLargura(); x++) {
            for (int y = 0; y < imgSrc.getAltura(); y++) {
                Coordenada xy = new Coordenada(x, y);
                ArrayList<Coordenada> coords = getCoordenadasRelativas(xy);
                ArrayList<Integer> vizinhos = getListaPixels(coords);
                int valorMediana = getMediana(vizinhos);
                RGB novo = new RGB(valorMediana, valorMediana, valorMediana);
                imgOut.put(xy, novo);
            }
        }
    }

    public void gerarImagemSaida(String caminho) throws IOException {
        BufferedImage saida = new BufferedImage(imgSrc.getLargura(), imgSrc.getAltura(), imgSrc.getTipo());
        imgOut.forEach((t, u) -> {
            saida.setRGB(t.getX(), t.getY(), (new Color(u.getR(), u.getG(), u.getB())).getRGB());
        });
        File out = new File(caminho);
        ImageIO.write(saida, "JPG", out);
    }

    private ArrayList<Coordenada> getCoordenadasRelativas(Coordenada xy) {
        ArrayList<Coordenada> coords = new ArrayList<>();
        int c = tamanhoJanela / 2;
        for (int n = 0; n < tamanhoJanela; n++) {
            for (int m = 0; m < tamanhoJanela; m++) {
                int novoX, novoY, distX, distY;
                distX = c - n;
                if (distX > 0) {
                    novoX = xy.getX() - distX;
                } else {
                    novoX = xy.getX() + distX;
                }
                distY = c - m;
                if (distY > 0) {
                    novoY = xy.getY() - distY;
                } else {
                    novoY = xy.getY() + distY;
                }
                coords.add(new Coordenada(novoX, novoY));
            }
        }
        return coords;
    }

    private ArrayList<Integer> getListaPixels(ArrayList<Coordenada> coords) {
        ArrayList<Integer> vizinhos = new ArrayList<>();
        coords.forEach((t) -> {
            RGB pxy = imgSrc.getRGB(t);
            if (pxy != null) {
                vizinhos.add(pxy.getR());
            }
        });
        return vizinhos;
    }

    private int getMediana(ArrayList<Integer> vizinhos) {
        vizinhos.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            }
            if (o1 > o2) {
                return 1;
            }
            return 0;
        });
        return vizinhos.get(vizinhos.size() / 2);
    }
}
