package mnenobot.lnclib.letterscode;

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
    /*
    * Этот метод собирает сообщение из буквенноцифрового кода
    * */
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
