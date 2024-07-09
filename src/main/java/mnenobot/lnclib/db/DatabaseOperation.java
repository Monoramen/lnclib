package mnenobot.lnclib.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
* DatabaseOperation Абстратный класс создает подключение 
* @getQuerry Получате queery ответ
* @setParameters устанавливает состояние
* @handleResults получаем queery запрос из базы
* @execute выполняет подключение
*/
public abstract class DatabaseOperation {
    protected abstract  String getQuerry();
    protected abstract void setParameters(PreparedStatement statement) throws SQLException; //бросает  исключения
    protected abstract void handleResults(ResultSet resultSet) throws SQLException;


    public void execute(){
        try(Connection connection = DatabaseConnection.connect()) {
            PreparedStatement statement = connection.prepareStatement(getQuerry());
            setParameters(statement);
            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                handleResults(resultSet);
            } else {
                statement.executeUpdate(); //если ничего не получили, то обновляем состояние
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

