import enums.DataType;
import interfaces.Database;
import interfaces.Table;
import models.Column;
import models.DatabaseImpl;
import validators.LargeValueValidator;
import validators.UniqueValidator;

import java.util.Arrays;

public class SqliteSimple {

    public static void main(String[] args) {
        Database db = new DatabaseImpl("testdb");

        Table table = db.createTable("testable", Arrays.asList(
                Column.builder()
                        .name("key")
                        .type(DataType.INT)
                        .validators(Arrays.asList(
                                new LargeValueValidator()
                        ))
                        .build(),
                Column.builder()
                        .name("value")
                        .type(DataType.STRING)
                        .validators(Arrays.asList())
                        .build()
        ));

        table.insert(Arrays.asList(1, "a"));
        table.insert(Arrays.asList(2, "b"));
        table.insert(Arrays.asList(3, "c"));
        table.insert(Arrays.asList(4, "d"));
        table.insert(Arrays.asList(14456, "e"));

        table.printall();
    }
}
