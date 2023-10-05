package Practica2.JCharts;

import Practica2.JParser.CSVParser;
import org.jfree.data.category.CategoryDataset;

public interface CreateDataBase {
    CategoryDataset createDataBase(CSVParser file, int xAxis, int yAxis);
}
