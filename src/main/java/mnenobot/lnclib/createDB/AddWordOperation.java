package mnenobot.lnclib.createDB;
import mnenobot.lnclib.db.DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddWordOperation extends DatabaseOperation {
    private final int codeId;
    private final String word;
    private final String tag;

    public AddWordOperation(int codeId, String word, String tag) {
        this.codeId = codeId;
        this.word = word;
        this.tag = tag;
    }

    @Override
    protected String getQuerry() {
        return "INSERT OR IGNORE INTO ru_words (word, code_id, tag) VALUES (?, ?, ?)";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        statement.setString(1, word);
        statement.setInt(2, codeId);
        statement.setString(3, tag);
    }

    @Override
    protected void handleResults(ResultSet resultSet) {
        // Ничего не делаем для insert операции
    }

}