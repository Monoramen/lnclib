package mnenobot.lnclib;

import java.util.List;
import java.util.Scanner;

import mnenobot.lnclib.createDB.DatabaseSetup;
import mnenobot.lnclib.db.SelectWordsFromCode;
import mnenobot.lnclib.db.SortCodeDataList;

// CreateDict - читает данные из файла
public class ParseFile  {
    public static void main(String[] args)  throws Exception {

        DatabaseSetup.createTables();

        //SortCodeDataList codesList = new SortCodeDataList();
        //System.out.println(codesList.getSortedData());
        Boolean loop = true;
        while(loop) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("введи код, а я найду слова которые им соответствуют");
            String code = scanner.nextLine();
            try {
                SelectWordsFromCode selectWordsFromCode = new SelectWordsFromCode(code);
                selectWordsFromCode.execute();
                List<String> words = selectWordsFromCode.getWords();
                for (String word : words) {
                    System.out.print(word + ", ");
                }
                return;
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
            
    }


    }
}