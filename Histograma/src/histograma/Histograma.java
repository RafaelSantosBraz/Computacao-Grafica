/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rafael Braz
 */
public class Histograma {

    private final HashMap<Integer, Integer> histograma;
    private String nome;

    public Histograma() {
        histograma = new HashMap<>();
        nome = "";
    }

    public Histograma(String nome) {
        histograma = new HashMap<>();
        this.nome = nome;
    }

    public Integer getValor(Integer pos) {
        Integer valor = histograma.get(pos);
        return valor != null ? valor : 0;
    }

    public void setValor(Integer pos) {
        if (getValor(pos) != null) {
            histograma.put(pos, getValor(pos) + 1);
        } else {
            histograma.put(pos, 1);
        }
    }

    public void exibirValores() {
        System.out.println("Nome: " + nome);
        histograma.forEach((t, u) -> {
            System.out.println("Valor " + t + " Quant " + u);
        });
    }

    public void exibirValoresDecrescente() {
        ArrayList<ChaveValor> lista = getValoresDescrescentes();
        System.out.println("Nome: " + nome);
        lista.forEach((t) -> {
            System.out.println("Valor " + t.getChave() + " Quant " + t.getValor());
        });
    }

    public void exibirValoresCrescente() {
        ArrayList<ChaveValor> lista = getValoresCrescentes();
        System.out.println("Nome: " + nome);
        lista.forEach((t) -> {
            System.out.println("Valor " + t.getChave() + " Quant " + t.getValor());
        });
    }

    public void exibirGrafico() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private ArrayList<ChaveValor> converterLista() {
        ArrayList<ChaveValor> lista = new ArrayList<>();
        histograma.forEach((t, u) -> {
            lista.add(new ChaveValor(t, u));
        });
        return lista;
    }

    public ArrayList<ChaveValor> getValoresDescrescentes() {
        ArrayList<ChaveValor> lista = converterLista();
        lista.sort((o1, o2) -> {
            if (o1.getValor() < o2.getValor()) {
                return 1;
            }
            if (o1.getValor() > o2.getValor()) {
                return -1;
            }
            return 0;
        });
        return lista;
    }

    public ArrayList<ChaveValor> getValoresCrescentes() {
        ArrayList<ChaveValor> lista = converterLista();
        lista.sort((o1, o2) -> {
            if (o1.getValor() < o2.getValor()) {
                return -1;
            }
            if (o1.getValor() > o2.getValor()) {
                return 1;
            }
            return 0;
        });
        return lista;
    }

    public HashMap<Integer, Integer> getValores() {
        return histograma;
    }

}
