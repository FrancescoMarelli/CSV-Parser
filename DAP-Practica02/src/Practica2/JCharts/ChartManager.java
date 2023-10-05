package Practica2.JCharts;

import Practica2.JParser.CSVParser;

import java.util.Scanner;

public class ChartManager {

    Chart chart;

    public ChartManager(CSVParser data) {
        // Crear gráfica
        System.out.println("Introduce el tipo de gráfica (bar/line):");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();

        data.getCSVFile().printHeaders();

        System.out.println("Introduce el indice del dataset que quieres como eje X:");
        int xAxis = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el indice del dataset que quieres como  eje Y:");
        int yAxis = Integer.parseInt(sc.nextLine());

        switch(type) {
            case "bar":
                chart = new BarChart("Bar Chart", "Bar Chart", data, xAxis, yAxis);
                chart.display();
                break;
            case "line":
                chart = new LineChart("Line Chart", "Line Chart", data, xAxis, yAxis);
                chart.display();
                break;
            default:
                System.out.println("Tipo de gráfica no soportada");
                System.exit(1);
        }

    }

    public void display() {
        chart.display();
    }

}
