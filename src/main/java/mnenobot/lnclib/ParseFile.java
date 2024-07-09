package mnenobot.lnclib;

import mnenobot.lnclib.createDB.DatabaseSetup;
import mnenobot.lnclib.db.SortCodeDataList;

// CreateDict - читает данные из файла
public class ParseFile {
    public static void main(String[] args) {

        DatabaseSetup.createTables();

        
        SortCodeDataList codesList = new SortCodeDataList();
        System.out.println(codesList.getSortedData());
    }
}

