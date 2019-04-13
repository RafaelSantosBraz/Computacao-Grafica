/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael Braz
 */
public class Histograma {

    private HashMap<Integer, Integer> histograma;
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

    public void preencherHistogramaVermelho(String caminho) {
        preencher(0, caminho);
    }

    public void preencherHistogramaVerde(String caminho) {
        preencher(1, caminho);
    }

    public void preencherHistogramaAzul(String caminho) {
        preencher(2, caminho);
    }

    private void preencher(int opRGB, String caminho) {
        try {
            histograma = new HashMap<>();
            File f = new File(caminho);
            BufferedImage img = ImageIO.read(f);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int z = 0; z < img.getHeight(); z++) {
                    Color c = new Color(img.getRGB(x, z));
                    switch (opRGB) {
                        case 0:
                            setValor(c.getRed());
                            break;
                        case 1:
                            setValor(c.getGreen());
                            break;
                        case 2:
                            setValor(c.getBlue());
                            break;
                    }

                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

    public void zerarHistograma() {
        histograma = new HashMap<>();
    }

    public ChaveValor getMenorChaveValor() {
        ArrayList<ChaveValor> valores = getValoresCrescentes();
        return valores.get(0);
    }

    public ChaveValor getMaiorChaveValor() {
        ArrayList<ChaveValor> valores = getValoresCrescentes();
        return valores.get(valores.size() - 1);
    }
}
