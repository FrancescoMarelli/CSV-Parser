package Practica2;

import Practica2.JParser.CSVParser;
import Practica2.JParser.Parser;
import Practica2.JParser.ParserManager;
import Practica2.URLManager.HTTPFileDownloader;
import Practica2.JCharts.*;

// link : https://opendata-ajuntament.barcelona.cat/data/dataset/16c11ddf-a783-4b64-aa68-3dc83dc70379/resource/d0e4ec78-e274-4300-a3bc-cb85cf79014d/download

public class Main {
    public static void main(String[] args) {

        // Url del archivo por argumento
        String url = args[0];
        // Descargar archivo
        System.out.println("Downloading from: " + url);
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");

        ParserManager parser = new ParserManager(contents);

        ChartManager chartManager = new ChartManager((CSVParser) parser.getData());
        chartManager.display();
    }
}
