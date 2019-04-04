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
 * @author aluno
 */
public class Vizinhanca4 {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;

    public Vizinhanca4(Imagem imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void calcular4VizinhancaHorVert() {
        imgOut = new HashMap<>();
        for (int x = 0; x < imgSrc.getLargura(); x++) {
            for (int y = 0; y < imgSrc.getAltura(); y++) {
                Coordenada xy = new Coordenada(x, y);
                ArrayList<RGB> vizinhos = getListaPixels(xy);
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
        RGB novo = new RGB(0, 0, 0);
        RGB p = imgSrc.getRGB(xy);
        novo.incrementarRGB(p);
        ArrayList<RGB> vizinhos = new ArrayList<>();
        vizinhos.add(novo);
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: {
                    Coordenada novoxy = new Coordenada(xy.getX() - 1, xy.getY());
                    RGB pxy = imgSrc.getRGB(novoxy);
                    if (pxy != null) {
                        vizinhos.add(pxy);
                    }
                }
                case 1: {
                    Coordenada novoxy = new Coordenada(xy.getX() + 1, xy.getY());
                    RGB pxy = imgSrc.getRGB(novoxy);
                    if (pxy != null) {
                        vizinhos.add(pxy);
                    }
                }
                case 2: {
                    Coordenada novoxy = new Coordenada(xy.getX(), xy.getY() + 1);
                    RGB pxy = imgSrc.getRGB(novoxy);
                    if (pxy != null) {
                        vizinhos.add(pxy);
                    }
                }
                case 3: {
                    Coordenada novoxy = new Coordenada(xy.getX(), xy.getY() - 1);
                    RGB pxy = imgSrc.getRGB(novoxy);
                    if (pxy != null) {
                        vizinhos.add(pxy);
                    }
                }
            }
        }
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
