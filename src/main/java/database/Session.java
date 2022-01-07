package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Session {
    private final Connection connection;

    public Session(Connection connection) {
        this.connection = connection;
    }


    public void remove(Model object) {
        String queryString = String.format("DELETE FROM %s where id = ?", object.getTableName());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, object.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
