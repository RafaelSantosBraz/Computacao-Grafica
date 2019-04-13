/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author rafael
 */
public class HistogramaRGB {

    private final Histograma red;
    private final Histograma green;
    private final Histograma blue;

    public HistogramaRGB() {
        red = new Histograma("Vermelho");
        green = new Histograma("Verde");
        blue = new Histograma("Azul");
    }

    public Histograma getRed() {
        return red;
    }

    public Histograma getGreen() {
        return green;
    }

    public Histograma getBlue() {
        return blue;
    }

    public void preencherHistograma(String caminho) {
        try {
            red.zerarHistograma();
            green.zerarHistograma();
            blue.zerarHistograma();
            File f = new File(caminho);
            BufferedImage img = ImageIO.read(f);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int z = 0; z < img.getHeight(); z++) {
                    Color c = new Color(img.getRGB(x, z));
                    red.setValor(c.getRed());
                    green.setValor(c.getGreen());
                    blue.setValor(c.getBlue());
                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
