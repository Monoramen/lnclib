package mnenobot.lnclib.createDB;

import mnenobot.lnclib.AbstractCSVReader;
import mnenobot.lnclib.SimpleReader;

// CreateDict - читает данные из файла
public class ParseFile {
    public static void main(String[] args) {
       // String path = "/data/semantics_simple.csv";
        DatabaseSetup.createTables();

        String semanticsSimpleFile = "data/emo_dict.csv";

        AbstractCSVReader reader = new SimpleReader();
        reader.readDataLineByLine(semanticsSimpleFile);

    }
}

