/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package Control;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;

/**
 *
 * @author Marco
 */
public class Grafico {

    public static void criaAcuracia(ArrayList<Resultado> resultados, JPanel painel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Resultado resultado : resultados) {
            dataset.setValue(resultado.taxaAcerto, "Marks", resultado.nome);
        }

        JFreeChart chart = ChartFactory.createBarChart("Acurácia", "Classificador", "Pontuação", dataset, PlotOrientation.HORIZONTAL, false, true, false);

        CategoryPlot p = chart.getCategoryPlot();

        p.setRangeGridlinePaint(Color.LIGHT_GRAY);
        ChartPanel cp = new ChartPanel(chart);
        cp.setDomainZoomable(true);
        painel.add(cp);
        painel.validate();
    }
    public static void criaTaxaErro(ArrayList<Resultado> resultados, JPanel painel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Resultado resultado : resultados) {
            dataset.setValue(resultado.taxaErro, "Marks", resultado.nome);
        }

        JFreeChart chart = ChartFactory.createBarChart("Taxa Erro", "Classificador", "Pontuação", dataset, PlotOrientation.HORIZONTAL, false, true, false);

        CategoryPlot p = chart.getCategoryPlot();

        p.setRangeGridlinePaint(Color.LIGHT_GRAY);
        ChartPanel cp = new ChartPanel(chart);
        cp.setDomainZoomable(true);
        painel.add(cp);
        painel.validate();
    }
    public static void criaPrecisao(ArrayList<Resultado> resultados, JPanel painel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Resultado resultado : resultados) {
            dataset.setValue(resultado.precisao, "Marks", resultado.nome);
        }

        JFreeChart chart = ChartFactory.createBarChart("Precisão", "Classificador", "Pontuação", dataset, PlotOrientation.HORIZONTAL, false, true, false);

        CategoryPlot p = chart.getCategoryPlot();

        p.setRangeGridlinePaint(Color.LIGHT_GRAY);
        ChartPanel cp = new ChartPanel(chart);
        cp.setDomainZoomable(true);
        painel.add(cp);
        painel.validate();
    }
    public static void criaRevocacao(ArrayList<Resultado> resultados, JPanel painel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Resultado resultado : resultados) {
            dataset.setValue(resultado.revocacao, "Marks", resultado.nome);
        }

        JFreeChart chart = ChartFactory.createBarChart("Revocação", "Classificador", "Pontuação", dataset, PlotOrientation.HORIZONTAL, false, true, false);

        CategoryPlot p = chart.getCategoryPlot();

        p.setRangeGridlinePaint(Color.LIGHT_GRAY);
        ChartPanel cp = new ChartPanel(chart);
        cp.setDomainZoomable(true);
        painel.add(cp);
        painel.validate();
    }
}
