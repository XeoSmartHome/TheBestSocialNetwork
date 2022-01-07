package database.columns;

public class StringColumn extends BaseColumn{
    private String value;

    public StringColumn(String name) {
        super(name);
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
