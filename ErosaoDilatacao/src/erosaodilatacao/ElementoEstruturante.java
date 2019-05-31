/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erosaodilatacao;

/**
 *
 * @author Rafael Braz
 */
public class ElementoEstruturante {

    private final boolean[][] masc;

    public ElementoEstruturante(int[][] elemento) throws Exception {
        this.masc = converter(elemento);
    }

    public boolean[][] getElemento() {
        return masc;
    }

    public int getTamanhoJanela() {
        return masc.length;
    }

    private boolean[][] converter(int[][] elemento) throws Exception {
        int count = elemento.length;
        for (int[] elem1 : elemento) {
            if (elem1.length != count) {
                throw new Exception("Elemento Estruturante deve ser uma matriz quadrada!");
            }
        }
        if (count % 2 != 0) {
            boolean[][] novo = new boolean[elemento.length][elemento.length];
            for (int c = 0; c < elemento.length; c++) {
                for (int i = 0; i < elemento.length; i++) {
                    switch (elemento[c][i]) {
                        case 0:
                            novo[c][i] = false;
                            break;
                        case 1:
                            novo[c][i] = true;
                            break;
                        default:
                            throw new Exception("Elemento Estruturante deve ser composto apenas por 0s e 1s!");
                    }
                }
            }
            return novo;
        } else {
            throw new Exception("Elemento Estruturante deve ser de tamanho ímpar!");
        }
    }

}
