/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IB1;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.Id3;
import weka.classifiers.trees.J48;
import weka.core.Instances;

/**
 *
 * @author Marco
 */
public class Classificador {

    public void classificar(Plano plano, Arquivo arq) {
        try {
            FileReader leitor = new FileReader(arq.arquivo);
            Instances conjunto = new Instances(leitor);
            conjunto.setClassIndex(conjunto.numAttributes());
            Evaluation avaliacao = new Evaluation(conjunto);
            conjunto = conjunto.resample(new Random());

            Instances baseTreino = null, baseTeste = null;

            if (plano.eHoldOut) {
                baseTeste = conjunto.testCV(3, 0);
                baseTreino = conjunto.trainCV(3, 0);
            }

            if (plano.IBK) {
                IB1 vizinho = new IB1();
                vizinho.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(vizinho, baseTeste, 4, null, 4);
            }
            if (plano.J48) {
                J48 j48 = new J48();
                j48.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(j48, baseTeste, 4, null, 4);
            }
            if (plano.KNN) {
                IBk knn = new IBk();
                knn.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(knn, baseTeste, 4, null, 4);
            }
            if (plano.Naive) {
                NaiveBayes naive = new NaiveBayes();
                naive.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(naive, baseTeste, 4, null, 4);
            }
            if (plano.Tree) {
                Id3 id3 = new Id3();
                id3.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(id3, baseTeste, 4, null, 4);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
