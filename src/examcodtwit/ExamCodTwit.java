/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examcodtwit;

import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class ExamCodTwit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodosTwit twit = new MetodosTwit();
        int opc;
        do {
            opc = JOptionPane.showOptionDialog(
                    null, "Selecciona una opción", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{
                        "TimeLine",
                        "Buscar",
                        "Tweettear",
                        "Exit"},
                    "Exit") + 1;

            switch (opc) {
                case 1:
                    twit.timeLine();
                    break;
                case 2:
                    twit.busqueda();
                    break;
                case 3:
                    twit.tweet();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opc != 0 && opc != 4);
    }
}
