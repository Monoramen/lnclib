package mnenobot.lnclib.letterscode;

import java.util.HashMap;
import java.util.Map;

public class RussianLetters extends AbstractLetters {

    private static final Map<Integer, String[]> CODES = new HashMap<>();

    static {
        CODES.put(0, new String[]{"Н", "М"});
        CODES.put(1, new String[]{"Г", "Ж"});
        CODES.put(2, new String[]{"Д", "Т"});
        CODES.put(3, new String[]{"К", "Х"});
        CODES.put(4, new String[]{"Ч", "Щ"});
        CODES.put(5, new String[]{"П", "Б"});
        CODES.put(6, new String[]{"Ш", "Л"});
        CODES.put(7, new String[]{"С", "З"});
        CODES.put(8, new String[]{"В", "Ф"});
        CODES.put(9, new String[]{"Р", "Ц"});
    }

    @Override
    protected Map<Integer, String[]> getCodesMap() {
        return CODES;
    }
}
