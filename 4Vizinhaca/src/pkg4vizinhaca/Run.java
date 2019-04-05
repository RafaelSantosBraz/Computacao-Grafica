/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4vizinhaca;

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
            Imagem img = new Imagem("D:\\GitHub\\Computacao-Grafica\\4Vizinhaca\\teste.jpg");
            Vizinhanca4 vizinhanca = new Vizinhanca4(img);
            vizinhanca.calcular4VizinhancaHorVert();
            vizinhanca.gerarImagemSaida("D:\\GitHub\\Computacao-Grafica\\4Vizinhaca\\out.jpg");
            vizinhanca.calcular4VizinhancaDiagonal();
            vizinhanca.gerarImagemSaida("D:\\GitHub\\Computacao-Grafica\\4Vizinhaca\\out1.jpg");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

}
