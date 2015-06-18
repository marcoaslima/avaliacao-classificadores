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
public class Plano {
    public String nomeDoPlano;
    
    public boolean KNN = false;
    public boolean Naive = false;
    public boolean IBK = false;
    public boolean J48 = false;
    public boolean Tree = false;

    public Boolean eHoldOut = false;
    public Boolean eLeaveOnOut = true;
    
    public Boolean exibeDetalhes = false;
    
    public Plano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }
    
    public static int metodo;
    
    public static int HoldOut = 0;
    public static int LeaveOneOut = 1;

    public String getNomeDoPlano() {
        return nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }

    public boolean isKNN() {
        return KNN;
    }

    public void setKNN(boolean KNN) {
        this.KNN = KNN;
    }

    public boolean isNaive() {
        return Naive;
    }

    public void setNaive(boolean Naive) {
        this.Naive = Naive;
    }

    public boolean isIBK() {
        return IBK;
    }

    public void setIBK(boolean IBK) {
        this.IBK = IBK;
    }

    public boolean isJ48() {
        return J48;
    }

    public void setJ48(boolean J48) {
        this.J48 = J48;
    }

    public boolean isTree() {
        return Tree;
    }

    public void setTree(boolean Tree) {
        this.Tree = Tree;
    }

    public static int getMetodo() {
        return metodo;
    }

    public static void setMetodo(int metodo) {
        Plano.metodo = metodo;
    }

    public static int getHoldOut() {
        return HoldOut;
    }

    public static void setHoldOut(int HoldOut) {
        Plano.HoldOut = HoldOut;
    }

    public static int getLeaveOneOut() {
        return LeaveOneOut;
    }

    public static void setLeaveOneOut(int LeaveOneOut) {
        Plano.LeaveOneOut = LeaveOneOut;
    }
    
    
    
}
