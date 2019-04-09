/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

import pkg4vizinhaca.Imagem;

/** 
 *
 * @author aluno
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Imagem img = new Imagem("C:\\Users\\aluno\\Desktop\\Computacao-Grafica\\Convolucao\\teste.jpg");
            double[][] mascara = {
                {-1, -1, -1},
                {-1, 9, -1},
                {-1, -1, -1}
            };
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
