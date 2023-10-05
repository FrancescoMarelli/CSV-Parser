package Practica2.JParser;


import java.util.ArrayList;
import java.util.Arrays;


public class CSVParser extends Parser {
    public static final String SEPARATOR = ",";
    private  CSVFile csvFile;

    public CSVParser(String[] rawContent) {
        super(rawContent);
    }

    public String[] getValuesNonRepeated(int xAxis) {
        ArrayList<String> values = new ArrayList<>();
        for (ArrayList<String> record : csvFile.getRecords()) {
            if (!values.contains(record.get(xAxis))) {
                values.add(record.get(xAxis));
            }
        }
        return values.toArray(new String[0]);
    }

    @Override
    public void parse() {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(data[0].split(SEPARATOR)));
        ArrayList<ArrayList<String>> records =  new ArrayList<>();
        csvFile = new CSVFile(headers, records);
        for (int i = 1; i < data.length; i++) {
            ArrayList<String> content = new ArrayList<>(Arrays.asList(data[i].split(SEPARATOR)));
            csvFile.getRecords().add(content);
        }
    }

    public CSVFile getCSVFile() {
        return csvFile;
    }
}
