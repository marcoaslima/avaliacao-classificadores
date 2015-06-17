/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import javax.swing.JTextArea;

/**
 *
 * @author Marco
 */
public class Console {
    public JTextArea areaTexto;

    public static String BASE_SELECIONADA = "Base de dados selecionada com sucesso";
    
    public Console(JTextArea areaTexto) {
        this.areaTexto = areaTexto;
    }
     
    public void adicionar(String texto){
        this.areaTexto.append(texto);
    }
}
