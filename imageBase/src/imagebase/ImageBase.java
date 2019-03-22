/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagebase;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author aluno
 */
public class ImageBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("C:\\Users\\aluno\\Desktop\\imageBase\\teste.jpg");
            BufferedImage img = ImageIO.read(f);
            BufferedImage redImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage greenImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage blueImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            int count = 0;
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color c = new Color(img.getRGB(x, y));
                    int rgb = img.getRGB(x, y);
                    //System.out.println("RGB: " + rgb);
                    //System.out.println("HEX: " + Integer.toHexString(rgb));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    //System.out.println("R: " + r + "G: " + g + "B: " + b);
                    Color colorRed = new Color(r, r, r);
                    Color colorGreen = new Color(g, g, g);
                    Color colorBlue = new Color(b, b, b);
                    redImage.setRGB(x, y, colorRed.getRGB());
                    greenImage.setRGB(x, y, colorGreen.getRGB());
                    blueImage.setRGB(x, y, colorBlue.getRGB());
                    count++;
                }
            }
            File out = new File("C:\\Users\\aluno\\Desktop\\imageBase\\out1.jpg");
            ImageIO.write(redImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\imageBase\\out2.jpg");
            ImageIO.write(greenImage, "JPG", out);
            out = new File("C:\\Users\\aluno\\Desktop\\imageBase\\out3.jpg");
            ImageIO.write(blueImage, "JPG", out);
            System.out.println(count);
        } catch (Exception e) {
        }
    }

}
