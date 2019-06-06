/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inverter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import pkg4vizinhaca.Coordenada;
import pkg4vizinhaca.Imagem;
import pkg4vizinhaca.RGB;

/**
 *
 * @author Rafael Braz
 */
public class Inversor {
    
    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;
    
    public Inversor(Imagem imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    public HashMap<Coordenada, RGB> getImgOut() {
        return imgOut;
    }
    
    public void inverter() {
        imgOut = new HashMap<>();
        imgSrc.getQuadro().forEach((t, u) -> {
            imgOut.put(Coordenada.getFromString(t), u.inverter());
        });
    }
    
    public void gerarImagemSaida(String caminho) throws IOException {
        BufferedImage saida = new BufferedImage(imgSrc.getLargura(), imgSrc.getAltura(), imgSrc.getTipo());
        imgOut.forEach((t, u) -> {
            saida.setRGB(t.getX(), t.getY(), (new Color(u.getR(), u.getG(), u.getB())).getRGB());
        });
        File out = new File(caminho);
        ImageIO.write(saida, "JPG", out);
    }
}
