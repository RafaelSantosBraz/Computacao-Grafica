/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiarizacao;

import java.io.IOException;

/**
 *
 * @author rafael
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // deve-se utilizar uma imagem em escala de cinza nesse algoritmo        
        try {
            Limiarizacao limi = new Limiarizacao(
                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Limiarizacao/teste.jpg",
                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Limiarizacao/out.jpg"
            );
            limi.aplicarLimiarOtsu();
            limi = new Limiarizacao(
                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Limiarizacao/teste.jpg",
                    "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/Limiarizacao/out1.jpg"
            );
            limi.aplicarLimiarProbabilidade();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.toString());
        }

    }

}
