package Practica2.JCharts;

import Practica2.JParser.CSVParser;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartDataBase implements CreateDataBase {
    @Override
    public CategoryDataset createDataBase(CSVParser file, int xAxis, int yAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String[] values = file.getValuesNonRepeated(xAxis);
        for (String value : values) {
            int count = 0;
            for (int j = 0; j < file.getCSVFile().getSize(); j++) {
                if (file.getCSVFile().getValue(j, xAxis).equals(value)) {
                    count++;
                }
            }
            dataset.addValue(count, value, file.getCSVFile().getHeaders().get(yAxis));
        }
        return dataset;
    }


}
