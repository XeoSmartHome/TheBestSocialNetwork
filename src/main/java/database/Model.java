package database;

import database.columns.BaseColumn;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Model {
    private final String id;

    public Model(String id) {
        this.id = id;
    }

    public abstract String getTableName();

    public String getId() {
        return id;
    }

    private ArrayList<BaseColumn> getColumns() {
        ArrayList<BaseColumn> columns = new ArrayList<BaseColumn>();

        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                Object obj = field.get(this);
                if(obj instanceof BaseColumn) {
                    columns.add((BaseColumn) obj);
                }

            } catch (IllegalAccessException e){
                System.out.println("");
            }
        }

        return columns;
    }

    public void save(Connection connection) {
        ArrayList<BaseColumn> columns = this.getColumns();

        String columnsNames = String.join(", ", columns.stream().map(BaseColumn::getName).toList());
        String questionMarks = String.join(", ", columns.stream().map((column) -> "?").toList());

        String queryString = String.format("INSERT INTO %s (%s) values (%s)", this.getTableName(), columnsNames, questionMarks);
        System.out.println(queryString);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);

            int index = 1;
            for (BaseColumn column : columns) {
                preparedStatement.setObject(index++, column.getValue());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Connection connection) {
        String queryString = String.format("DELETE FROM %s where id = ?", this.getTableName());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, this.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
