/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiarizacao;

import histograma.Grafico;
import histograma.Histograma;
import java.io.IOException;

/**
 *
 * @author rafael
 */
public class Limiarizacao {

    private final String srcPath;
    private final String outPath;

    public Limiarizacao(String srcPath, String outPath) {
        this.srcPath = srcPath;
        this.outPath = outPath;
    }

    public void aplicarLimiarOtsu() throws IOException {
        Histograma histRed = new Histograma("Vermelho");
        histRed.preencherHistogramaVermelho(srcPath);
        //Grafico graph = new Grafico(histRed);
        Otsu ot = new Otsu(histRed);
        int t = ot.calcularOtsu();
        ot.gerarImagemSaida(outPath, histRed.getImg(), t);
        //graph.criarGraficoLimiar(t);
    }

}
