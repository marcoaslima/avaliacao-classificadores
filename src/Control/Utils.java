/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.text.DecimalFormat;

/**
 *
 * @author Marco
 */
public class Utils {

    public static String paraDuasCasas(double valor) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(valor);
    }
    
    public static String porcentagem(double valor){
        return paraDuasCasas(valor *100) + "%";
    }
}
