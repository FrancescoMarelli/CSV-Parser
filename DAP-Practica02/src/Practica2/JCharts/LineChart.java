package Practica2.JCharts;

import Practica2.JParser.CSVParser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class LineChart extends Chart {
    public LineChart(String applicationTitle, String chartTitle, CSVParser file, int xAxis, int yAxis) {
        super(applicationTitle, xAxis, yAxis);
        createDataBase  =  new LineChartDatabase();
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                // X axis
                file.getCSVFile().getHeaders().get(xAxis),
                // Y axis
                file.getCSVFile().getHeaders().get(yAxis),
                (CategoryDataset) createDataBase.createDataBase(file, xAxis, yAxis),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension( 600 ,400 ) );
        setContentPane(chartPanel);
    }

    public void display() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
