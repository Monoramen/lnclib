package mnenobot.lnclib.createDB;

import mnenobot.lnclib.db.DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCodeOperation extends DatabaseOperation {
    
    private final String code;
    
    public AddCodeOperation(String code){
        this.code = code;
    }
    
    @Override
    protected String getQuerry() {
        return "INSERT OR IGNORE INTO ru_word_codes (code) VALUES (?)";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
    statement.setString(1,code);
    }

    @Override
    protected void handleResults(ResultSet resultSet) throws SQLException {

    }


}
