/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inverter;

import java.io.IOException;
import pkg4vizinhaca.Imagem;

/**
 *
 * @author Rafael Braz
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Imagem img = new Imagem("D:\\GitHub\\Computacao-Grafica\\Inverter\\testeCinza.jpg");
            Inversor inv = new Inversor(img);
            inv.inverter();
            inv.gerarImagemSaida("D:\\GitHub\\Computacao-Grafica\\Inverter\\out.jpg");
        } catch (IOException e) {
            System.err.println("Erro: " + e.toString());
        }
    }
    
}
