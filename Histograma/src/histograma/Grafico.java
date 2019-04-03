/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histograma;

import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Rafael Braz
 */
public class Grafico extends JFrame {
    
    private final Histograma histograma;
    private final DefaultCategoryDataset barra;
    private JFreeChart grafico;
    
    public Grafico(Histograma histograma) {
        this.histograma = histograma;
        barra = new DefaultCategoryDataset();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Histograma");
        setSize(950, 700);
        setLocationRelativeTo(null);
        setVisible(false);
    }
    
    public void criarGrafico() {
        adicionarValores();
        grafico = ChartFactory.createBarChart3D(histograma.getNome(), "Valor 'RGB'", "Quantidade", barra, PlotOrientation.VERTICAL, false, true, false);
        tornarPreto();
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
        setVisible(true);
    }
    
    public void criarGraficoLimiar(Integer limiar) {
        criarGrafico();
        destacarLimiar(limiar);
    }
    
    private void adicionarValores() {
        for (Integer c = 0; c < 256; c++) {
            barra.setValue(0, c, "");
        }
        histograma.getValores().forEach((t, u) -> {
            barra.setValue(u, t, "");
        });
    }
    
    private void tornarPreto() {
        int quant = grafico.getCategoryPlot().getDataset().getRowCount();
        CategoryPlot barraItem = grafico.getCategoryPlot();
        for (int c = 0; c < quant; c++) {
            barraItem.getRenderer().setSeriesPaint(c, Color.BLACK);
        }
    }
    
    public void destacarLimiar(Integer limiar) {
        CategoryPlot barraItem = grafico.getCategoryPlot();
        barraItem.getRenderer().setSeriesPaint(limiar, Color.PINK);
    }
}
