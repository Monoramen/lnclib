package mnenobot.lnclib.createDB;

import mnenobot.lnclib.AbstractLetters;
import mnenobot.lnclib.Letters;

public class WordCode {
    private final AbstractLetters letters;

    public WordCode(AbstractLetters letters) {
        this.letters = letters;
    }

    public String getCode(String word) {
        StringBuilder code = new StringBuilder();
        for (char letter : word.toCharArray()) {
            Integer codeForLetter = letters.getCode(String.valueOf(letter));
            if (codeForLetter != null) {
                code.append(codeForLetter);
            }
        }
        return code.toString();
    }
}
