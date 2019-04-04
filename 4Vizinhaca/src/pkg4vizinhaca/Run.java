/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4vizinhaca;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Imagem img = new Imagem("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\4Vizinhaca\\teste.jpg");
            Vizinhanca4 vizinhanca = new Vizinhanca4(img);
            vizinhanca.gerarImagemSaida("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\4Vizinhaca\\out.jpg");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }
    
}
