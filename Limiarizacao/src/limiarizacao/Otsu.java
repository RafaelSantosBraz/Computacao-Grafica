/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiarizacao;

import histograma.Histograma;

/**
 *
 * @author rafael
 */
public class Otsu {

    private final Histograma P;

    public Otsu(Histograma histograma) {
        P = histograma;
    }

    public int calcularOtsu() {
        double max = 0;
        //int maxt = 0;
        for (int t = 0; t < 256; t++) {
            int w0 = 0, ut = 0, uT = 0;
            for (int i = 0; i <= t; i++) {
                w0 += P.getValor(i);
                ut += i * P.getValor(i);
                if (i != t) {
                    uT += i * P.getValor(i);
                }
            }
            int w1 = 1 - w0;
            double u0 = (double) ut / w0;
            double u1 = (uT - ut) / (1 - u0);
            double a2B = w0 * w1 * Math.pow(u1 * u0, 2);
            double a2T = 0;
            for (int i = 0; i < t; i++) {
                a2T += Math.pow(1 - uT, 2) * P.getValor(i);
            }
            double n = (a2B / a2T);
            if (n > max) {
                max = n;
                //maxt = t;
            }
        }
        return (int) max;
    }

}
