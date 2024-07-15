package mnenobot.lnclib.createDB;
import mnenobot.lnclib.db.DatabaseOperation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddAssociate extends DatabaseOperation {
    private final String word;
    private final String associatedWord;
    private final String partOfSpeech;

    public AddAssociate(String word, String associatedWord, String partOfSpeech) {
        this.word = word;
        this.associatedWord = associatedWord;
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    protected String getQuerry() {
        return "INSERT OR IGNORE INTO ru_assoc (word_id, associated_word_id, part_of_speech) VALUES ((SELECT id FROM ru_words WHERE word = ?), (SELECT id FROM ru_words WHERE word = ?), ?)";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        statement.setInt(1, GetIDFromWord.getWordID(word));
        statement.setInt(2, GetIDFromWord.getWordID(associatedWord));
        statement.setString(3, partOfSpeech);
    }
    

    @Override
    protected void handleResults(ResultSet resultSet) {
        // Ничего не делаем для insert операции
    }
}
