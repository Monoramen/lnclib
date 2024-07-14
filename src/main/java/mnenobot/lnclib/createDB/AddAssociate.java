package mnenobot.lnclib.createDB;
import mnenobot.lnclib.db.DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddAssociate extends DatabaseOperation {
    private final int wordId;
    private final int associatedWord;
    private final String partOfSpeech;

    public AddAssociate(int wordId, int associatedWord, String partOfSpeech) {
        this.wordId = wordId;
        this.associatedWord = associatedWord;
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    protected String getQuerry() {
        return "INSERT OR IGNORE INTO ru_assoc (word_id, associated_word_id, part_of_speech) VALUES (?, ?, ?)";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        statement.setInt(1, wordId);
        statement.setInt(2, associatedWord);
        statement.setString(3, partOfSpeech);
    }

    @Override
    protected void handleResults(ResultSet resultSet) {
        // Ничего не делаем для insert операции
    }
}