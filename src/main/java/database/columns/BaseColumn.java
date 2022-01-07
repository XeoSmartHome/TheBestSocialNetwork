package database.columns;

public abstract class BaseColumn {
    private final String name;

    public BaseColumn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Object getValue();

}
