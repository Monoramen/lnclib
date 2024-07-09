package mnenobot.lnclib.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
*
* Данные для подключения к базе
* connect метод выполняющи
*  */

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:database.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
