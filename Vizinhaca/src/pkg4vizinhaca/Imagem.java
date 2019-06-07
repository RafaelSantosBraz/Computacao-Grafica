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

    private HashMap<String, RGB> quadro;
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

    private Imagem(HashMap<String, RGB> quadro, File f, BufferedImage img, int largura, int altura, int tipo) {
        this.quadro = quadro;
        this.f = f;
        this.img = img;
        this.largura = largura;
        this.altura = altura;
        this.tipo = tipo;
    }

    public void rePreencherQuadro(HashMap<Coordenada, RGB> novo) {
        quadro = new HashMap<>();
        novo.forEach((t, u) -> {
            adicionar(t, u.clonar());
        });
    }

    private void adicionar(Coordenada coordenada, RGB rgb) {
        String coord = coordenada.getX() + ";" + coordenada.getY();
        quadro.put(coord, rgb);
    }

    public RGB getRGB(Coordenada coordenada) {
        String coord = coordenada.getX() + ";" + coordenada.getY();
        return quadro.get(coord);
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

    public HashMap<String, RGB> getQuadro() {
        return quadro;
    }

    public Imagem copiarComOutroQuadro(HashMap<String, RGB> novoQuadro) {
        return new Imagem(novoQuadro, f, img, largura, altura, tipo);
    }
    
    public Imagem copiarComQuadroClonado(){
        return new Imagem(clonarQuadro(), f, img, largura, altura, tipo);
    }
    
    public HashMap<String, RGB> clonarQuadro(){
        HashMap<String, RGB> novo = new HashMap<>();
        quadro.forEach((t, u) -> {
            novo.put(t, u.clonar());
        });
        return novo;
    }
    
    public Imagem copiar(){
        return new Imagem(quadro, f, img, largura, altura, tipo);
    }
}
