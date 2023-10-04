package Practica2.JCharts;

import Practica2.ParserManager.CSVParser;
import org.jfree.data.category.CategoryDataset;

public interface iCreateDataBase {
    CategoryDataset createDataBase(CSVParser file, int xAxis, int yAxis);
}
