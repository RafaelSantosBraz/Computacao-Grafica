/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiarizacao;

import histograma.Grafico;
import histograma.Histograma;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author rafael
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Histograma histRed = new Histograma("Vermelho");
            Histograma histGreen = new Histograma("Verde");
            Histograma histBlue = new Histograma("Azul");
            File f = new File("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Limiarizacao/teste.jpg");
            BufferedImage img = ImageIO.read(f);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int z = 0; z < img.getHeight(); z++) {
                    Color c = new Color(img.getRGB(x, z));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    histRed.setValor(r);
                    histGreen.setValor(g);
                    histBlue.setValor(b);
                }
            }
//            Grafico graph = new Grafico(histRed);
//            graph.criarGrafico();
//            Grafico graph2 = new Grafico(histGreen);
//            graph2.criarGrafico();
//            Grafico graph3 = new Grafico(histBlue);
//            graph3.criarGrafico();
            int t = new Otsu(histBlue).calcularOtsu();
            System.out.println("T = " + t);
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
    }

}
