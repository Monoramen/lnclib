package mnenobot.lnclib;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLetters implements Letters {

    protected abstract Map<Integer, String[]> getCodesMap();
    @Override
    public Map<Integer, String[]> getCodes() {
        return getCodesMap();
    }

    @Override
    public Integer getCode(String letter) {
        Map<Integer, String[]> codes = getCodesMap();
        for (Map.Entry<Integer, String[]> entry : codes.entrySet()) {
            String[] chars = entry.getValue();
            for (String c : chars) {
                if (letter.toLowerCase().equals(c.toLowerCase())) {
                    return entry.getKey();
                }
            }
        }
        return null; // return null if letter not found
    }

    @Override
    public String getCodesString() {
        StringBuilder msg = new StringBuilder();
        Map<Integer, String[]> codes = getCodesMap();
        for (Map.Entry<Integer, String[]> entry : codes.entrySet()) {
            msg.append(entry.getKey()).append(" - ");
            for (String c : entry.getValue()) {
                msg.append(c).append(", ");
            }
            msg.setLength(msg.length() - 2); // remove last two characters (comma and space)
            msg.append("\n");
        }
        return msg.toString();
    }

}


class RussianLetters extends AbstractLetters {

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

class EnglishLetters extends AbstractLetters {

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