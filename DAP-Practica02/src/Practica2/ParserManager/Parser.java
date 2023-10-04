package Practica2.ParserManager;

public abstract class Parser {
    protected String[] data;

    public Parser(String[] data) {
        this.data = data;
    }

    public abstract void parse();
}
