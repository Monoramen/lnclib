package mnenobot.lnclib.db;

import mnenobot.lnclib.createDB.AddCodeOperation;
import mnenobot.lnclib.createDB.AddWordOperation;
import mnenobot.lnclib.createDB.GetCodeIdOperation;


public class CodeWordImporter {
    public static void addCode(String code) {
        new AddCodeOperation(code).execute();
    }

    public static void addWord(int codeId, String word, String tag) {
        new AddWordOperation(codeId, word, tag).execute();
    }

    public static int getCodeId(String code) {
        return new GetCodeIdOperation(code).getCodeId();
    }
}
