package Practica2.JCharts;

import Practica2.ParserManager.CSVParser;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartDataBase implements iCreateDataBase {
    @Override
    public CategoryDataset createDataBase(CSVParser file, int xAxis, int yAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String[] xAxisValues = file.getValuesNonRepeated(xAxis);
        for (int i = 0; i < xAxisValues.length; i++) {
            int sum = 0;
            for (int j = 0; j < file.getSize(); j++) {
                if (file.getValue(j, xAxis).equals(xAxisValues[i])) {
                    // Sum all the values of the same category in the Y axis
                    // BECAUSE THE CSV FILE IS NOT WELL FORMED (IT HAS REPEATED VALUES IN THE X AXIS)
                    // I HAVE TO SUM ALL THE VALUES OF THE SAME CATEGORY IN THE Y AXIS
                    sum += Integer.parseInt(file.getValue(j, yAxis));
                }
            }
            // Add the sum of the values of the same category in the Y axis
            dataset.addValue(sum, file.getValue(i, xAxis), file.getValue(i, yAxis));
        }
        return dataset;
    }
}
