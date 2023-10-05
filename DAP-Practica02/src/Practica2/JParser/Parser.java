package Practica2.JParser;

public abstract class Parser {
    protected String[] data;

    public Parser(String[] data) {
        this.data = data;
    }

    public abstract void parse();
}
