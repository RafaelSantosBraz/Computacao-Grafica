/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

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
 * @author aluno
 */
public class Convolucao {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;
    private final Mascara mascara;

    public Convolucao(Imagem imgSrc, Mascara mascara) {
        this.imgSrc = imgSrc;
        this.mascara = mascara;
    }

    public void aplicarConvolucao() {
        imgOut = new HashMap<>();
        for (int x = 0; x < imgSrc.getLargura(); x++) {
            for (int y = 0; y < imgSrc.getAltura(); y++) {
                Coordenada xy = new Coordenada(x, y);
                ArrayList<CoordenadaPeso> coordPeso = mascara.getCoordenadasRelativas(xy);
                ArrayList<RGB> vizinhos = getListaPixels(coordPeso);
                RGB novo = calcularMediapixels(vizinhos, coordPeso);
                imgOut.put(xy, novo);
            }
        }
    }

    private ArrayList<RGB> getListaPixels(ArrayList<CoordenadaPeso> coords) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        vizinhos.addAll(getListaBase(coords));
        return vizinhos;
    }

    private ArrayList<RGB> getListaBase(ArrayList<CoordenadaPeso> coords) {
        ArrayList<RGB> vizinhos = new ArrayList<>();
        coords.forEach((t) -> {
            RGB pxy = imgSrc.getRGB(t);
            if (pxy != null) {
                pxy = pxy.clonar();
                double peso = t.getPeso();
                pxy.setR((int) (pxy.getR() * peso));
                pxy.setG((int) (pxy.getG() * peso));
                pxy.setB((int) (pxy.getB() * peso));
                vizinhos.add(pxy);
            }
        });
        return vizinhos;
    }

    private double somarPesos(ArrayList<CoordenadaPeso> coords) {
        double peso = 0.0;
        for (CoordenadaPeso cp : coords) {
            if (imgSrc.getRGB(cp) != null) {
                peso += cp.getPeso();
            }
        }
        return peso;
    }

    private RGB calcularMediapixels(ArrayList<RGB> vizinhos, ArrayList<CoordenadaPeso> coords) {
        RGB novo = new RGB(0, 0, 0);
        vizinhos.forEach((t) -> {
            novo.incrementarRGB(t);
        });
        //calcularMediaRGB(novo, coords.size());
        calcularMediaRGB(novo, somarPesos(coords));
         //novo.normalizarRGB();
        return novo;
    }

    private void calcularMediaRGB(RGB p, double quant) {
        p.setR((int) (p.getR() / quant));
        p.setG((int) (p.getG() / quant));
        p.setB((int) (p.getB() / quant));
        p.normalizarRGB();
    }

    public void gerarImagemSaida(String caminho) throws IOException {
        BufferedImage saida = new BufferedImage(imgSrc.getLargura(), imgSrc.getAltura(), imgSrc.getTipo());
        imgOut.forEach((t, u) -> {
            Color c = new Color(u.getR(), u.getG(), u.getB());
            // System.out.println("Antes: " + imgSrc.getRGB(t) + " Depois: " + u);
            saida.setRGB(t.getX(), t.getY(), c.getRGB());
        });
        File out = new File(caminho);
        ImageIO.write(saida, "JPG", out);
    }
}
