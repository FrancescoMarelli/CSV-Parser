package Practica2.JParser;

public class ParserManager {
    String[] contents;
    Parser data;

    public ParserManager(String[] contents) {
        this.contents = contents;
        data = new CSVParser(contents);
        data.parse();
    }

    public Parser getData() {
        return data;
    }
}
