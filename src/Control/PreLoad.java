/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Marco
 */
public class PreLoad {

    public static String[] preLoadFiles = {"/lib/JTattoo-1.6.11.jar", "/lib/weka.jar"};

    public static String fileNotLoaded;
    public static String parent;
    
    public static boolean runVerify() {
        Boolean notCorrupted = true;
        try {
            parent = new File(".").getCanonicalPath();
        } catch (Exception ex) {
            return false;
        }

        for (String path : PreLoad.preLoadFiles) {
            File file = new File(parent + path);
            if (!file.exists()) {
                notCorrupted = false;
                fileNotLoaded = path;
                break;
            }
        }
        return notCorrupted;
    }
}
