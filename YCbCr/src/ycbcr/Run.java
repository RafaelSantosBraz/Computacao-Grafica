/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycbcr;

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
            File f = new File("C:\\Users\\aluno\\Desktop\\YCbCr\\teste.jpg");
            BufferedImage img = ImageIO.read(f);
            BufferedImage redImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage greenImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage blueImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            int count = 0;
            for (int x = 0; x < img.getWidth(); x++) {
                for (int z = 0; z < img.getHeight(); z++) {
                    Color c = new Color(img.getRGB(x, z));
                    //System.out.println("RGB: " + rgb);
                    //System.out.println("HEX: " + Integer.toHexString(rgb));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    //System.out.println("R: " + r + "G: " + g + "B: " + b);
                    double y = 16 + (65.738 * r / 256) + (129.057 * g / 256) + (25.064 * b / 256);
                    double cb = 128 - (37.945 * r / 256) - (74.494 * g / 256) + (112.439 * b / 256);
                    double cr = 128 + (112.439 * r / 256) - (94.154 * b / 256) - (18.258 * b / 256);

                    double ny = (y - 16) / (218) * 255;
                    double ncb = (y - 16) / (224) * 255;
                    double ncr = (y - 16) / (224) * 255;

                    redImage.setRGB(x, z, new Color((int) y, (int) y, (int) y).getRGB());
                    greenImage.setRGB(x, z, new Color((int) cb, (int) cb, (int) cb).getRGB());
                    blueImage.setRGB(x, z, new Color((int) cr, (int) cr, (int) cr).getRGB());
                    count++;
                }
            }
            File out = new File("C:\\Users\\aluno\\Desktop\\YCbCr\\out1.jpg");
            ImageIO.write(redImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\YCbCr\\out2.jpg");
            ImageIO.write(greenImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\YCbCr\\out3.jpg");
            ImageIO.write(blueImage, "JPG", out);
            System.out.println(count);
        } catch (Exception e) {
        }
    }
}
