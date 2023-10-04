package Practica2.JCharts;

import Practica2.ParserManager.CSVParser;
import Practica2.ParserManager.Parser;

import java.util.Scanner;

public class ChartManager {

    public ChartManager(CSVParser data) {
        // Crear gráfica
        System.out.println("Introduce el tipo de gráfica (bar/line):");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        System.out.println("Introduce el indice del dataset que quieres como eje X:");
        int xAxis = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el indice del dataset que quieres como  eje Y:");
        int yAxis = Integer.parseInt(sc.nextLine());

        Chart chart;
        if (type.equals("bar")) {
            chart = new BarChart("Practica02", "Practica02", data, xAxis, yAxis);
        }
        else chart = new LineChart("Practica02", "Practica02", data, xAxis, yAxis);
        // Mostrar gráfica
        chart.display();

    }

}
