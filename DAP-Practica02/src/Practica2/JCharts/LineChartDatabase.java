package Practica2.JCharts;

import Practica2.JParser.CSVFile;
import Practica2.JParser.CSVParser;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartDatabase implements CreateDataBase {

    public CategoryDataset createDataBase(CSVParser file, int xAxis, int yAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] xAxisValues = file.getValuesNonRepeated(xAxis);
        for (int i = 0; i < xAxisValues.length; i++) {
            int sum = 0;
            for (int j = 0; j < file.getCSVFile().getSize(); j++) {
                if (file.getCSVFile().getValue(j, xAxis).equals(xAxisValues[i])) {
                    sum += Integer.parseInt(file.getCSVFile().getValue(j, yAxis));
                }
            }
            dataset.addValue(sum, file.getCSVFile().getValue(i, xAxis), file.getCSVFile().getValue(i, yAxis));
            System.out.println("Sum of " + file.getCSVFile().getValue(i, xAxis) + " is " + sum);
        }
        return dataset;
    }

}