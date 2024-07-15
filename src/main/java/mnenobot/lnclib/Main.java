package mnenobot.lnclib;


import mnenobot.lnclib.createDB.DatabaseSetup;
import mnenobot.lnclib.readers.AbstractCSVReader;
import mnenobot.lnclib.readers.AssocReader;


// CreateDict - читает данные из файла
public class Main  {
    public static void main(String[] args)  throws Exception {

        DatabaseSetup.createTables();

        //SortCodeDataList codesList = new SortCodeDataList();
        //System.out.println(codesList.getSortedData());

    System.out.println("\t========Начинаю создавать коды для слов ассоциаций.... =========\n");
    String pathFile = "data/assoc.csv";
    AbstractCSVReader reader = new AssocReader();
    reader.readDataLineByLine(pathFile);

    }
}