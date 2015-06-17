/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Marco
 */
public class Arquivo {
    public String conteudo;
    public File arquivo;
    
    public File importar() {
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filterARFF = new FileNameExtensionFilter("Arquivo de dados Wekka", "arff");
        FileNameExtensionFilter filterTSDB = new FileNameExtensionFilter("Arquivo de dados TCS", "tsdb");

        fc.setFileFilter(filterTSDB);
        fc.setFileFilter(filterARFF);
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.arquivo = fc.getSelectedFile();
            return this.arquivo;
        } else {
            return null;
        }
    }

    public String leArquivo(File arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            this.conteudo = sb.toString();
        }catch(Exception ex){
           
        }
        return this.conteudo;
    }
}
