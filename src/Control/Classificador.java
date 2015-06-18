/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
import weka.core.UnsupportedAttributeTypeException;

/**
 *
 * @author Marco
 */
public class Classificador {

    ArrayList<Resultado> resultados = new ArrayList<>();

    public ArrayList<Resultado> classificar(Plano plano, Arquivo arq) {
        try {
            FileReader leitor = new FileReader(arq.arquivo);
            Instances conjunto = new Instances(leitor);
            conjunto.setClassIndex(conjunto.numAttributes() - 1);
            Evaluation avaliacao = new Evaluation(conjunto);
            conjunto = conjunto.resample(new Random());

            Instances baseTreino = null, baseTeste = null;
            Random rand = new Random(1);

            if (plano.eHoldOut) {
                baseTeste = conjunto.testCV(3, 0);
                baseTreino = conjunto.trainCV(3, 0);
            } else {
                baseTeste = baseTreino = conjunto;
            }

            if (plano.IBK) {
                try {
                    IB1 vizinho = new IB1();
                    vizinho.buildClassifier(baseTeste);
                    avaliacao.crossValidateModel(vizinho, baseTeste, (plano.eHoldOut) ? 4 : baseTeste.numInstances(), rand);
                    Resultado resultado = new Resultado("Vizinho Mais Próximo", avaliacao.toMatrixString("Algorítmo Vizinho Mais Próximo - Matriz de Confusão"), avaliacao.toClassDetailsString("kNN"));
                    resultado.setTaxaErro(avaliacao.errorRate());
                    resultado.setTaxaAcerto(1 - avaliacao.errorRate());
                    resultado.setRevocacao(recallToDouble(avaliacao, baseTeste));
                    resultado.setPrecisao(precisionToDouble(avaliacao, baseTeste));
                    this.resultados.add(resultado);
                } catch (UnsupportedAttributeTypeException ex) {
                    Mensagem.erro("Algorítmo IB1 não suporta atributos numéricos!", "MTCS - ERRO");
                }
            }
            if (plano.J48) {
                try {
                    J48 j48 = new J48();
                    j48.buildClassifier(baseTeste);
                    avaliacao.crossValidateModel(j48, baseTeste, (plano.eHoldOut) ? 4 : baseTeste.numInstances(), rand);
                    Resultado resultado = new Resultado("J48", avaliacao.toMatrixString("Algorítmo J48 - Matriz de Confusão") , avaliacao.toClassDetailsString("J48"));
                    resultado.setTaxaErro(avaliacao.errorRate());
                    resultado.setTaxaAcerto(1 - avaliacao.errorRate());
                    resultado.setRevocacao(recallToDouble(avaliacao, baseTeste));
                    resultado.setPrecisao(precisionToDouble(avaliacao, baseTeste));
                    this.resultados.add(resultado);
                } catch (UnsupportedAttributeTypeException ex) {
                    Mensagem.erro("Algorítmo J48 não suporta atributos nominais!", "MTCS - ERRO");
                }
            }
            if (plano.KNN) {
                try {
                    IBk knn = new IBk();
                    knn.buildClassifier(baseTeste);
                    avaliacao.crossValidateModel(knn, baseTeste, (plano.eHoldOut) ? 4 : baseTeste.numInstances(), rand);
                    Resultado resultado = new Resultado("KNN", avaliacao.toMatrixString("Algorítmo KNN - Matriz de Confusão"), avaliacao.toClassDetailsString("kNN"));
                    resultado.setTaxaErro(avaliacao.errorRate());
                    resultado.setTaxaAcerto(1 - avaliacao.errorRate());
                    resultado.setRevocacao(recallToDouble(avaliacao, baseTeste));
                    resultado.setPrecisao(precisionToDouble(avaliacao, baseTeste));
                    this.resultados.add(resultado);
                } catch (UnsupportedAttributeTypeException ex) {
                    Mensagem.erro("Algorítmo KNN não suporta atributos numéricos!", "MTCS - ERRO");
                }

            }
            if (plano.Naive) {
                NaiveBayes naive = new NaiveBayes();
                naive.buildClassifier(baseTeste);
                avaliacao.crossValidateModel(naive, baseTeste, (plano.eHoldOut) ? 4 : baseTeste.numInstances(), rand);
                Resultado resultado = new Resultado("Algorítmo Naive Bayes", avaliacao.toMatrixString("Algorítmo NaiveBayes - Matriz de Confusão"), avaliacao.toClassDetailsString("kNN"));
                resultado.setTaxaErro(avaliacao.errorRate());
                resultado.setTaxaAcerto(1 - avaliacao.errorRate());
                resultado.setRevocacao(recallToDouble(avaliacao, baseTeste));
                resultado.setPrecisao(precisionToDouble(avaliacao, baseTeste));
                this.resultados.add(resultado);
            }
            if (plano.Tree) {
                try {
                    Id3 id3 = new Id3();
                    id3.buildClassifier(baseTeste);
                    avaliacao.crossValidateModel(id3, baseTeste, (plano.eHoldOut) ? 4 : baseTeste.numInstances(), rand);
                    Resultado resultado = new Resultado("ID3", avaliacao.toMatrixString("Algorítmo ID3 - Matriz de Confusão") , avaliacao.toClassDetailsString("kNN"));
                    resultado.setTaxaErro(avaliacao.errorRate());
                    resultado.setTaxaAcerto(1 - avaliacao.errorRate());
                    resultado.setRevocacao(recallToDouble(avaliacao, baseTeste));
                    resultado.setPrecisao(precisionToDouble(avaliacao, baseTeste));
                    this.resultados.add(resultado);
                } catch (UnsupportedAttributeTypeException ex) {
                    Mensagem.erro("Algorítmo Arvore de Decisão não suporta atributos numéricos!", "MTCS - ERRO");

                }
            }

        } catch (FileNotFoundException ex) {

            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Mensagem.erro("Selecione um arquivo para começar!", "MTCS - ERRO");
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Classificador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.resultados;
    }

    public String resultadoToString() {
        String resultadoStr = "";

        for (Resultado resultado : resultados) {
            resultadoStr += ("\n" + /*resultado.resultado +*/ resultado.matriz  + "\nAcurácia: " + Utils.porcentagem(resultado.taxaAcerto) + "\nErro:" + Utils.porcentagem(resultado.taxaErro) + "\nRevocação:" + Utils.porcentagem(resultado.revocacao)+ "\nPrecisão:" + Utils.porcentagem(resultado.precisao));
            resultadoStr += ("\n====================================================================\n");
        }
        return resultadoStr;
    }

    public double recallToDouble(Evaluation avaliacao, Instances base) {
        double resultadoDbl = 0;
        for (int i = 0; i < base.numClasses(); i++) {
            resultadoDbl += avaliacao.recall(i);
        }
        return resultadoDbl / base.numClasses();
    }

    public double precisionToDouble(Evaluation avaliacao, Instances base) {
        double resultadoDbl = 0;
        for (int i = 0; i < base.numClasses(); i++) {
            resultadoDbl += avaliacao.precision(i);
        }
        return resultadoDbl / base.numClasses();
    }
    

}
