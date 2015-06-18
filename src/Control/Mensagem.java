/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class Mensagem {
    public static boolean questao(String texto, String titulo){
        return (JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public static void erro(String texto, String titulo){
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
