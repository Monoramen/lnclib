package mnenobot.lnclib.letterscode;
import java.util.Map;

public interface Letters {
    Map<Integer, String[]> getCodes();
    Integer getCode(String letter);
    String getCodesString();
}



