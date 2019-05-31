/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erosaodilatacao;

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
            // algoritmo que transforma imagem em escala de cinza para filtros Laplacianos e outros
//                EscalaCinza cinza = new EscalaCinza(
//                        "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/teste.jpg", 
//                        "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg"
//                );
//                cinza.converter();
//                img = new Imagem("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Convolucao/testeCinza.jpg");
            Imagem img = new Imagem("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/ErosaoDilatacao/testeCinza.jpg");
            int[][] elemEstr = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
            };
            ElementoEstruturante elemento = new ElementoEstruturante(elemEstr);
            OperacaoED operacao = new OperacaoED(img, elemento);
            operacao.erosao(10);
            //operacao.dilatacao(10);
            operacao.gerarImagemSaida("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/ErosaoDilatacao/out.jpg");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
