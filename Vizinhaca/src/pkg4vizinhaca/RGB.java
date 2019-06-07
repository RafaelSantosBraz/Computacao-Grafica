/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4vizinhaca;

import histograma.HistogramaRGB;

/**
 *
 * @author aluno
 */
public class RGB {

    private int R;
    private int G;
    private int B;

    public RGB(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

    public void setR(int R) {
        this.R = R;
    }

    public void setG(int G) {
        this.G = G;
    }

    public void setB(int B) {
        this.B = B;
    }

    public void adicionarR(int R) {
        this.R += R;
    }

    public void adicionarG(int G) {
        this.G += G;
    }

    public void adicionarB(int B) {
        this.B += B;
    }

    public void incrementarRGB(RGB rgb) {
        R += rgb.getR();
        G += rgb.getG();
        B += rgb.getB();
    }

    public void normalizarRGB(HistogramaRGB histograma) {
        Integer menorR = histograma.getRed().getMenorChaveValor().getChave(), maiorR = histograma.getRed().getMaiorChaveValor().getChave();
        Integer menorG = histograma.getGreen().getMenorChaveValor().getChave(), maiorG = histograma.getGreen().getMaiorChaveValor().getChave();
        Integer menorB = histograma.getBlue().getMenorChaveValor().getChave(), maiorB = histograma.getBlue().getMaiorChaveValor().getChave();
        R = (R - menorR) / (maiorR - menorR);
        G = (G - menorG) / (maiorG - menorG);
        B = (B - menorB) / (maiorB - menorB);
        if (R > 255) {
            R = 255;
        } else if (R < 0) {
            R = 226;
        }
        if (G > 255) {
            G = 255;
        } else if (G < 0) {
            G = 226;
        }
        if (B > 255) {
            B = 255;
        } else if (B < 0) {
            B = 226;
        }
    }

    public void normalizarRGB() {
        if (R > 255) {
            R = 255;
        } else if (R < 0) {
            R = 0;
        }
        if (G > 255) {
            G = 255;
        } else if (G < 0) {
            G = 0;
        }
        if (B > 255) {
            B = 255;
        } else if (B < 0) {
            B = 0;
        }
    }

    public RGB clonar() {
        return new RGB(R, G, B);
    }

    @Override
    public String toString() {
        return "RGB{" + "R=" + R + ", G=" + G + ", B=" + B + '}';
    }

    public RGB inverter() {
        return new RGB(255 - R, 255 - G, 255 - B);
    }

    public static RGB subtrair(RGB rgb1, RGB rgb2) {
        RGB novo = new RGB(rgb1.getR() - rgb2.getR(), rgb1.getG() - rgb2.getG(), rgb1.getB() - rgb2.getB());
        novo.normalizarRGB();
        return novo;
    }
}
