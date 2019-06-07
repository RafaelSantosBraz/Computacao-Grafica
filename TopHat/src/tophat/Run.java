/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tophat;

import erosaodilatacao.ElementoEstruturante;
import erosaodilatacao.OperacaoED;
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
            Imagem img = new Imagem("D:\\GitHub\\Computacao-Grafica\\TopHat\\testeCinza.jpg");
            int[][] elemEstr = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
            };
            ElementoEstruturante elemento = new ElementoEstruturante(elemEstr);
            TopHat topHat = new TopHat(img, elemento);
            topHat.abertura(1);
            topHat.gerarImagemSaida("D:\\GitHub\\Computacao-Grafica\\TopHat\\out.jpg");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }

    }

}
