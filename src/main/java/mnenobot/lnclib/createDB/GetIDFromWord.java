package mnenobot.lnclib.createDB;

import mnenobot.lnclib.db.DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetIDFromWord extends DatabaseOperation {
    private String word;
    private int wordID = -1;


    @Override
    protected String getQuerry() {
        return "SELECT id FROM ru_words WHERE word = ?";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        statement.setString(1, word);
    }

    @Override
    protected void handleResults(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            wordID = resultSet.getInt("id");
        }
    }
    public static int getWordID(String word) {
        GetIDFromWord operation = new GetIDFromWord();
        operation.word = word;
        operation.execute();
        return operation.wordID;
    }
}
