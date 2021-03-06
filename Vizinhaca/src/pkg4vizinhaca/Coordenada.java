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
public class Coordenada {

    private final int x;
    private final int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordenada clonar() {
        return new Coordenada(x, y);
    }

    public static Coordenada getFromString(String coordenada) {
        String[] valores = coordenada.split(";");
        return new Coordenada(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]));
    }

}
