package Practica2.JCharts;

import Practica2.JParser.CSVParser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class BarChart extends Chart {
    public BarChart(String applicationTitle, String chartTitle, CSVParser file, int xAxis, int yAxis) {
        super(applicationTitle, xAxis, yAxis);
        if(xAxis > file.getCSVFile().getHeaders().size() || yAxis > file.getCSVFile().getHeaders().size()) throw new IndexOutOfBoundsException();

        createDataBase = new BarChartDataBase();
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                // X axis
                file.getCSVFile().getHeaders().get(xAxis),
                // Y axis=
                file.getCSVFile().getHeaders().get(yAxis),
                createDataBase.createDataBase(file, xAxis, yAxis),
                PlotOrientation.VERTICAL,
                true, true, false);

        // Add the chart to a panel to display it
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension( 600 ,400 ) );
        setContentPane(chartPanel);
    }

    public void display() {
        // Display the chart in a window frame (JFrame) and center it on the screen
        // Source: https://www.tutorialspoint.com/jfreechart/jfreechart_quick_guide.htm
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
