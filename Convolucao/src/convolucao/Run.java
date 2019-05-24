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
            Imagem img = new Imagem("/home/cc47192962899/Área de Trabalho/Computacao-Grafica/Convolucao/teste.jpg");
            double fracao = 1.0 / 1;
            double[][] mascara = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
            };
            Mascara masc = new Mascara(mascara, fracao);
            if (masc.verificarMascara()) {            
                
                // algoritmo que transforma imagem em escala de cinza para filtros Laplacianos e outros
//                EscalaCinza cinza = new EscalaCinza(
//                        "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/teste.jpg", 
//                        "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg"
//                );
//                cinza.converter();
//                img = new Imagem("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg");
               
                Convolucao conv = new Convolucao(img, masc);
                // método aplica concolução sem normalizar com máximo e mínimo
                //conv.aplicarConvolucao();     
                // método aplica concolução com  normalizar com máximo e mínimo
                conv.aplicarConvolucaoMaximoMinimo();
                // último parâmetro 1 normaliza com valor máximo e mínimo
                conv.gerarImagemSaida("/home/cc47192962899/Área de Trabalho/Computacao-Grafica/Convolucao/out.jpg", 1);
            } else {
                System.out.println("Máscara Inválida!");
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
