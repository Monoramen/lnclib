package mnenobot.lnclib.letterscode;

import java.util.Map;
import java.util.HashMap;

public class EnglishLetters extends AbstractLetters {

    private static final Map<Integer, String[]> CODES = new HashMap<>();

    static {
        CODES.put(0, new String[]{"S", "Z"});
        CODES.put(1, new String[]{"T", "D", "TH"});
        CODES.put(2, new String[]{"N"});
        CODES.put(3, new String[]{"M"});
        CODES.put(4, new String[]{"R"});
        CODES.put(5, new String[]{"L"});
        CODES.put(6, new String[]{"J", "CH", "SH"});
        CODES.put(7, new String[]{"C", "K", "G", "Q", "CK"});
        CODES.put(8, new String[]{"V", "F", "PH"});
        CODES.put(9, new String[]{"P", "B"});
    }

    @Override
    protected Map<Integer, String[]> getCodesMap() {
        return CODES;
    }
}