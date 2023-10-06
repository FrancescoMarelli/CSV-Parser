package Practica2;

import Practica2.JParser.CSVParser;
import Practica2.JParser.Parser;
import Practica2.JParser.ParserManager;
import Practica2.URLManager.HTTPFileDownloader;
import Practica2.JCharts.*;

import java.util.Scanner;

// link : https://opendata-ajuntament.barcelona.cat/data/dataset/16c11ddf-a783-4b64-aa68-3dc83dc70379/resource/d0e4ec78-e274-4300-a3bc-cb85cf79014d/download
// link2: https://opendata-ajuntament.barcelona.cat/data/dataset/8645f8ff-152e-4733-9bff-202f611ef755/resource/b30e365f-b96c-4b32-aff4-ac88276ad79c/download


public class Main {
    public static void main(String[] args) {

        // Url del archivo por argumento
        System.out.println("1. Para trabajar con fichero de la practica");
        System.out.println("2. Para trabajar con fichero de la modificación");
        Scanner sc = new Scanner(System.in);
        int option = Integer.parseInt(sc.nextLine());
        String url;
        if(option == 1) {
            url = args[0];
        } else {
            url = args[1];
        }

        // Descargar archivo
        System.out.println("Downloading from: " + url);
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");

        ParserManager parser = new ParserManager(contents);

        ChartManager chartManager = new ChartManager((CSVParser) parser.getData());
        chartManager.display();
    }
}
