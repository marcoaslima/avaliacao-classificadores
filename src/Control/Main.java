/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.formLoad;
import View.formMain;
import javax.swing.UIManager;

/**
 *
 * @author Marco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (Exception ex) {
        }

       /* formLoad load = new formLoad();
        load.setLocationRelativeTo(null);
        load.setVisible(true);
        load.load();*/
        
        formMain main = new formMain();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }

}
