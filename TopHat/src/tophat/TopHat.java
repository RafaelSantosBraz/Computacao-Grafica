/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tophat;

import erosaodilatacao.ElementoEstruturante;
import erosaodilatacao.OperacaoED;
import inverter.Inversor;
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
public class TopHat {

    private final Imagem imgSrc;
    private HashMap<Coordenada, RGB> imgOut;
    private final ElementoEstruturante elemEstr;

    public TopHat(Imagem imgSrc, ElementoEstruturante elemEstr) {
        this.imgSrc = imgSrc;
        this.elemEstr = elemEstr;
    }

    public void abertura(int repeticoes) {
        OperacaoED operacao = new OperacaoED(imgSrc, elemEstr);
        operacao.abertura(repeticoes);
        HashMap<Coordenada, RGB> resultado = subtracao(imgSrc.getQuadro(), operacao.getImgOut());
        Imagem imgResultado = imgSrc.copiar();
        imgResultado.rePreencherQuadro(resultado);
        Inversor inv = new Inversor(imgResultado);
        inv.inverter();
        imgOut = inv.getImgOut();
    }

    private HashMap<Coordenada, RGB> subtracao(HashMap<String, RGB> original, HashMap<Coordenada, RGB> segunda) {
        HashMap<String, RGB> novoQuadro = new HashMap<>();
        segunda.forEach((t, u) -> {
            novoQuadro.put(t.getX() + ";" + t.getY(), u);
        });
        HashMap<Coordenada, RGB> resultado = new HashMap<>();
        original.forEach((t, u) -> {            
            resultado.put(Coordenada.getFromString(t), RGB.subtrair(u, novoQuadro.get(t)));
        });
        return resultado;
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
