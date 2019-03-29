/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

/**
 *
 * @author rafael
 */
public class ChaveValor {

    private final Integer chave;
    private final Integer valor;

    public ChaveValor(Integer chave, Integer valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public Integer getChave() {
        return chave;
    }

    public Integer getValor() {
        return valor;
    }

}
