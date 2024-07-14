package mnenobot.lnclib.letterscode;

public class WordCode {
    private final AbstractLetters letters;

    public WordCode(AbstractLetters letters) {
        this.letters = letters;
    }

    public String getCode(String word) {
        StringBuilder code = new StringBuilder();
        for (String letter : word.split("")) {
            Integer codeForLetter = letters.getCode(String.valueOf(letter));
            if (codeForLetter != null) {
                code.append(codeForLetter);
            }
        }
        return code.toString();
    }
}
