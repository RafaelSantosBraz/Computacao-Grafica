/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author aluno
 */
public class HSI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\HSI\\teste.jpg");
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
                    double r = c.getRed() / 255.0;
                    double g = c.getGreen() / 255.0;
                    double b = c.getBlue() / 255.0;
                    //System.out.println("R: " + r + "G: " + g + "B: " + b);
                    double teta = Math.acos((0.5 * (r - g) + (r - b)) / (Math.pow(Math.pow(r - g, 2) + (r - b) * (g - b), 0.5)));
                    double h;
                    if (b <= g) {
                        h = teta;
                    } else {
                        h = 2 * Math.PI - teta;
                    }
                    double i = (r + g + b) / 3;
                    double s = 1 - (3 / (r + g + b)) * Math.min(Math.min(r, g), b);

                    h = delim(h * 255);
                    s = delim(s * 255);
                    i = delim(i * 255);

                    redImage.setRGB(x, z, new Color((int) h, (int) h, (int) h).getRGB());
                    greenImage.setRGB(x, z, new Color((int) s, (int) s, (int) s).getRGB());
                    blueImage.setRGB(x, z, new Color((int) i, (int) i, (int) i).getRGB());
                    count++;
                }
            }
            File out = new File("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\HSI\\out1.jpg");
            ImageIO.write(redImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\HSI\\out2.jpg");
            ImageIO.write(greenImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\HSI\\out3.jpg");
            ImageIO.write(blueImage, "JPG", out);
            System.out.println(count);
        } catch (Exception e) {
        }
    }

    public static double delim(double x) {
        if (x < 0) {
            return 0;
        } else if (x > 255) {
            return 255;
        }
        return x;
    }
}
