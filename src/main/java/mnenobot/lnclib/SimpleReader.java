package mnenobot.lnclib;

import mnenobot.lnclib.db.DBOperation;
import mnenobot.lnclib.createDB.WordCode;

public class SimpleReader extends AbstractCSVReader {
    private final WordCode wordCode;

    public SimpleReader() {
        this.wordCode = new WordCode(new RussianLetters());
    }

    @Override
    protected void processRow(String[] row) {
        String word = row[0];
        String tag = row[1];
        String value = row[2];

        String code = wordCode.getCode(word);

        if (code != null && code.matches("\\d+")) {
            try {
                DBOperation.addCode(code);
                int codeId = DBOperation.getCodeId(code);
                DBOperation.addWord(codeId, word, tag);
            } catch (Exception e) {
                System.out.println("Ошибка при добавлении слова в БД: " + word);
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка при получении кода слова: " + word);
        }
    }
}
