package mnenobot.lnclib.readers;

import mnenobot.lnclib.db.CodeWordImporter;
import mnenobot.lnclib.letterscode.*;

public class SimpleReader extends AbstractCSVReader {
    private final WordCode wordCode;

    public SimpleReader() {
        this.wordCode = new WordCode(new RussianLetters());
    }

    @Override
    protected void processRow(String[] row) {
        String word = row[0];
        String tag = row[1];

        String code = wordCode.getCode(word);

        if (code != null && code.matches("\\d+")) {
            try {
                CodeWordImporter.addCode(code);
                int codeId = CodeWordImporter.getCodeId(code);
                CodeWordImporter.addWord(codeId, word, tag);
            } catch (Exception e) {
                System.out.println("Ошибка при добавлении слова в БД: " + word);
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка при получении кода слова: " + word);
        }
    }
}
