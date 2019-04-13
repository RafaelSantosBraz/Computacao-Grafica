/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolucao;

import histograma.Grafico;
import histograma.HistogramaRGB;
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
            HistogramaRGB histograma = new HistogramaRGB();
            histograma.preencherHistograma("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/teste.jpg");
            Grafico r = new Grafico(histograma.getRed());
            r.criarGrafico();
            Grafico g = new Grafico(histograma.getGreen());
            g.criarGrafico();
            Grafico b = new Grafico(histograma.getBlue());
            b.criarGrafico();
            System.out.println(histograma.getRed().getMenorChaveValor().getChave());
            System.out.println(histograma.getRed().getMaiorChaveValor().getChave());
            Imagem img = new Imagem("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/teste.jpg");
            double fracao = 1.0 / 1;
            double[][] mascara = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
            };
            Mascara masc = new Mascara(mascara, fracao);
            if (masc.verificarMascara()) {
                Convolucao conv = new Convolucao(img, masc);
                conv.aplicarConvolucao();
                conv.gerarImagemSaida("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/out.jpg");
            } else {
                System.out.println("Máscara Inválida!");
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
