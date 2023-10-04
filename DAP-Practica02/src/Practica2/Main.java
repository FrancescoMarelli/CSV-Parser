package Practica2;

import java.util.Scanner;
import Practica2.ParserManager.CSVParser;
import Practica2.URLManager.HTTPFileDownloader;
import Practica2.JCharts.*;

public class Main {
    public static void main(String[] args) {
        // Introducir archivo para descargar
        Scanner sc = new Scanner(System.in);
        String url;
        if (args.length == 0) {
            System.out.println("Introduce la URL del archivo CSV:");
            url = sc.nextLine();
        } else {
            url = args[0];
        }
        System.out.println("Introduce la URL del archivo CSV:");

        // Descargar archivo
        System.out.println("Downloading from: " + url);
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");
        CSVParser data = new CSVParser(contents);
        data.parse();

        // Crear gráfica
        System.out.println("Introduce el tipo de gráfica (bar/line):");
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
