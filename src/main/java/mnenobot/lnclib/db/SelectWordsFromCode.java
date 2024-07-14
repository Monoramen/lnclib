package mnenobot.lnclib.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectWordsFromCode extends DatabaseOperation {

    private List<String> words;
    private String code;

    public SelectWordsFromCode(String code){
        this.code = code;
    }
/*
JOIN ru_word_codes ON ru_words.code_id = ru_word_codes.id - эта строка объединяет 
две таблицы, ru_words и ru_word_codes, 
на основе общих столбцов между ними. 
В этом случае мы объединяем таблицы по столбцу code_id в таблице 
ru_words и столбцу id в таблице ru_word_codes
*/
    @Override
    protected String getQuerry() {
        try {
            return "SELECT ru_words.word " +
                   "FROM ru_words " +
                   "JOIN ru_word_codes ON ru_words.code_id = ru_word_codes.id " +
                   "WHERE ru_word_codes.code = ?;";
        } catch (Exception e) {
            return "%s" + e.getStackTrace();
        }
    }


    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        // TODO: Установите значение параметра для кода
        statement.setString(1, code );
    }

    @Override
    protected void handleResults(ResultSet resultSet) throws SQLException {
        words = new ArrayList<>();
        while (resultSet.next()) {
            String word = resultSet.getString("word");
            words.add(word);
        }
    }

    public List<String> getWords() {
        return words;
    }



}
