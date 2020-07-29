package interfaces;

import models.Column;

import java.util.List;

public interface Database {
    public Table createTable(String name, List<Column> columns);
}
