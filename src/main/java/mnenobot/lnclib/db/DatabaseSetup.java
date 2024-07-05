package mnenobot.lnclib.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void createTables() {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();

            String createWordCodesTable = "CREATE TABLE IF NOT EXISTS ru_word_codes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "code TEXT NOT NULL UNIQUE" +
                    ")";
            statement.execute(createWordCodesTable);

            String createWordsTable = "CREATE TABLE IF NOT EXISTS ru_words (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "word TEXT UNIQUE NOT NULL," +
                    "code_id INTEGER NOT NULL," +
                    "tag TEXT," +
                    "FOREIGN KEY (code_id) REFERENCES ru_word_codes (id)" +
                    ")";
            statement.execute(createWordsTable);

            String createWordsEmoTable = "CREATE TABLE IF NOT EXISTS ru_emo_dict (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "word_id INTEGER NOT NULL," +
                    "type TEXT," +
                    "value REAL," +
                    "FOREIGN KEY (word_id) REFERENCES ru_words (id)" +
                    ")";
            statement.execute(createWordsEmoTable);

            String createSemanticsTable = "CREATE TABLE IF NOT EXISTS ru_semantics (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "word_id INTEGER," +
                    "category TEXT," +
                    "subcategory TEXT," +
                    "score REAL," +
                    "FOREIGN KEY (word_id) REFERENCES ru_words (id)" +
                    ")";
            statement.execute(createSemanticsTable);

            String createAssocTable = "CREATE TABLE IF NOT EXISTS ru_assoc (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "word_id INTEGER," +
                    "associated_word_id INTEGER," +
                    "part_of_speech TEXT," +
                    "type TEXT," +
                    "score REAL," +
                    "FOREIGN KEY (word_id) REFERENCES ru_words (id)," +
                    "FOREIGN KEY (associated_word_id) REFERENCES ru_words (id)" +
                    ")";
            statement.execute(createAssocTable);
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблиц: " + e.getMessage());
        }
    }
}
