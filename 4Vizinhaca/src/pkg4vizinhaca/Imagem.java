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
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author aluno
 */
public class Imagem {

    private final HashMap<Coordenada, RGB> quadro;
    private final File f;
    private final BufferedImage img;
    private final int largura;
    private final int altura;
    private final int tipo;

    public Imagem(String caminho) throws IOException {
        quadro = new HashMap<>();
        f = new File(caminho);
        img = ImageIO.read(f);
        largura = img.getWidth();
        altura = img.getHeight();
        tipo = img.getType();
        preencher();
    }

    private void adicionar(Coordenada coordenada, RGB rgb) {
        quadro.put(coordenada, rgb);
    }

    public RGB getRGB(Coordenada coordenada) {
        return quadro.get(coordenada);
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getTipo() {
        return tipo;
    }

    private void preencher() {
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                Color c = new Color(img.getRGB(x, y));
                RGB rgb = new RGB(c.getRed(), c.getGreen(), c.getBlue());
                adicionar(new Coordenada(x, y), rgb);
            }
        }
    }
}
