package mnenobot.lnclib.createDB;

import mnenobot.lnclib.db.DatabaseOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCodeIdOperation extends DatabaseOperation {
    private final String code;
    private int codeId = -1;

    public GetCodeIdOperation(String code) {
        this.code = code;
    }
    
    @Override
    protected String getQuerry() {
        return "SELECT id FROM ru_word_codes WHERE code = ?";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {
        statement.setString(1, code);
    }

    @Override
    protected void handleResults(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            codeId = resultSet.getInt("id");
        }
    }

    public int getCodeId() {
        execute();
        return codeId;
    }
}
