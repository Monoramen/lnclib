package mnenobot.lnclib.createDB;

import mnenobot.lnclib.AbstractCSVReader;
import mnenobot.lnclib.SimpleReader;

// CreateDict - читает данные из файла
public class ParseFile {
    public static void main(String[] args) {
       // String path = "/data/semantics_simple.csv";
        DatabaseSetup.createTables();
        //data/emo_dict.csv
        ///data/kartaslovsent.csv
        System.out.println("\t========Начинаю создавать коды для слов.... =========\n".repeat(10));
        String semanticsSimpleFile = "data/kartaslovsent.csv";

        AbstractCSVReader reader = new SimpleReader();
        reader.readDataLineByLine(semanticsSimpleFile);

    }
}

