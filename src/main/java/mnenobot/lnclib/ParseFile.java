package mnenobot.lnclib;

import mnenobot.lnclib.createDB.DatabaseSetup;
import mnenobot.lnclib.db.SortCodeDataList;

// CreateDict - читает данные из файла
public class ParseFile {
    public static void main(String[] args) {
       // String path = "/data/semantics_simple.csv";
        DatabaseSetup.createTables();
        //data/emo_dict.csv
        ///data/kartaslovsent.csv
        ///data/semantics.csv
        //System.out.println("\t========Начинаю создавать коды для слов.... =========\n".repeat(10));
        //String semanticsSimpleFile = "data/semantics.csv";

        //AbstractCSVReader reader = new SimpleReader();
        //reader.readDataLineByLine(semanticsSimpleFile);
        SortCodeDataList codesList = new SortCodeDataList();
        System.out.println(codesList.getSortedData());
    }
}

