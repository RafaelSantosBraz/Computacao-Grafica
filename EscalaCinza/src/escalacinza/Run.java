/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalacinza;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EscalaCinza cinza = new EscalaCinza("/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/EscalaCinza/teste.jpg", "/media/rafael/Dados Compartilhados/GitHub/Computacao-Grafica/EscalaCinza/out.jpg");
        try {
            cinza.converter();
        } catch (IOException ex) {
            System.out.println("Erro ao manipular arquivos: " + ex.toString());
        }
    }

}
