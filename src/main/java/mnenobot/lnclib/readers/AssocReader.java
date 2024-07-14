package mnenobot.lnclib.readers;

import mnenobot.lnclib.db.CodeWordImporter;
import mnenobot.lnclib.letterscode.RussianLetters;
import mnenobot.lnclib.letterscode.WordCode;

public class AssocReader extends AbstractCSVReader {
    private final WordCode wordCode;

    public AssocReader() {
        this.wordCode = new WordCode(new RussianLetters());
    }

    @Override
    protected void processRow(String[] row) {
        String word = row[0];
        String assoc = row[1];
        String partOfSpeech = row[2];

        String code1 = wordCode.getCode(word);
        String code2 = wordCode.getCode(assoc);

        if (code1 != null && code1.matches("\\d+")) {
            try {
                CodeWordImporter.addCode(code1);
                int codeId = CodeWordImporter.getCodeId(code1);
                CodeWordImporter.addWord(codeId, word, partOfSpeech);
            } catch (Exception e) {
                System.out.println("Ошибка при добавлении слова в БД: " + word);
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка при получении кода слова: " + word);
        }
    }
}
