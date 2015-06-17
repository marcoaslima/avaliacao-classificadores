/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.io.File;

/**
 *
 * @author Marco
 */
public class PreLoad {
    public static String[] preLoadFiles = {};
    
    public static String fileNotLoaded;
    
    public static boolean runVerify(){
        Boolean notCorrupted = true;
        
        for(String path: PreLoad.preLoadFiles){
            File file = new File(path);
            if(!file.exists()){
                notCorrupted = false;
                fileNotLoaded = path;
                break;
            }
        }
        return notCorrupted;
    }
}
