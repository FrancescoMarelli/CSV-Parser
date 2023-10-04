package Practica2.ParserManager;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser extends Parser {
    public static final String SEPARATOR = ",";
    private  ArrayList<String> headers;
    private  ArrayList<ArrayList<String>> records;

    public CSVParser(String[] rawContent) {
        super(rawContent);
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }
    public String getValue(int i, int j) {
        return records.get(i).get(j);
    }
    public int getSize() {
        return records.size();
    }
    public String[] getValuesNonRepeated(int xAxis) {
        ArrayList<String> values = new ArrayList<>();
        for (ArrayList<String> record : records) {
            if (!values.contains(record.get(xAxis))) {
                values.add(record.get(xAxis));
            }
        }
        return values.toArray(new String[0]);
    }


    @Override
    public void parse() {
        headers = new ArrayList<>(Arrays.asList(data[0].split(SEPARATOR)));
        records = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            ArrayList<String> content = new ArrayList<>(Arrays.asList(data[i].split(SEPARATOR)));
            records.add(content);
        }
    }
}
