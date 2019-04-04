/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4vizinhaca;

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
}
