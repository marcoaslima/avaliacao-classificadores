/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Marco
 */
public class Resultado {

    public String nome;
    public String matriz;
    public String detalhes;
    public Object dados;
    public double taxaErro;
    public double taxaAcerto;
    public double precisao;
    public double revocacao;

    public Resultado(String nome, String matriz, String detalhes) {
        this.nome = nome;
        this.matriz = matriz;
        this.detalhes = detalhes;
    }

    void setTaxaErro(double d) {
        this.taxaErro = d;
    }

    void setTaxaAcerto(double d) {
        this.taxaAcerto = d;
    }

    void setRevocacao(double recallToDouble) {
        this.revocacao = recallToDouble;
    }

    void setPrecisao(double precisionToDouble) {
        this.precisao = precisionToDouble;
    }

}
