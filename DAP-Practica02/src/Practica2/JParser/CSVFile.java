package Practica2.JParser;

import java.util.ArrayList;

public class CSVFile {
    private final ArrayList<String> headers;
    private final ArrayList<ArrayList<String>> records;

    public CSVFile(ArrayList<String> headers, ArrayList<ArrayList<String>> records) {
        this.headers = headers;
        this.records = records;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public String getValue(int i, int j) {
        return records.get(i).get(j);
    }

    public int getSize() {
        int lines = 0;
        for (ArrayList<String> row : this.records)
            lines++;
        return lines;
    }

    public ArrayList<ArrayList<String>> getRecords() {
        return records;
    }

    public void printHeaders() {
        int i = 0;
        for (String header : getHeaders()) {
            System.out.println(i + ". " + header);
            i++;
        }
        System.out.println();
    }

}
