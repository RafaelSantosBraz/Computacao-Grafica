/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtromediana;

import escalacinza.EscalaCinza;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Imagem img = new Imagem("D:\\GitHub\\Computacao-Grafica\\FiltroMediana\\teste.jpg");
            // algoritmo que transforma imagem em escala de cinza para aplicar a mediana
//            EscalaCinza cinza = new EscalaCinza(
//                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/teste.jpg",
//                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg"
//            );
//            cinza.converter();
//            img = new Imagem("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg");
            // segundo parâmetro indica o tamanho da janela, que deve ser ímpar
            Mediana filtroMediana = new Mediana(img, 11);
            filtroMediana.mediana();
            filtroMediana.gerarImagemSaida("D:\\GitHub\\Computacao-Grafica\\FiltroMediana\\out.jpg");
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.toString());
        }

    }

}
