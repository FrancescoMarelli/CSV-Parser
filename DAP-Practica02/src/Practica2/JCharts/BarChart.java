package Practica2.JCharts;

import Practica2.ParserManager.CSVParser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class BarChart extends Chart {
    public BarChart(String applicationTitle, String chartTitle, CSVParser file, int xAxis, int yAxis) {
        super(applicationTitle, xAxis, yAxis);
        createDataBase = new ChartDataBase();
        if(xAxis > file.getHeaders().size() || yAxis > file.getHeaders().size()) throw new IndexOutOfBoundsException();
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                // X axis
                file.getHeaders().get(xAxis),
                // Y axis
                file.getHeaders().get(yAxis),
                createDataBase.createDataBase(file, xAxis, yAxis),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension( 600 ,400 ) );
        setContentPane(chartPanel);
    }

    public void display() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
