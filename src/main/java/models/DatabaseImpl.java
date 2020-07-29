package models;

import interfaces.Database;
import interfaces.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseImpl implements Database {

    private String name;
    private Map<String, Table> tables = new HashMap<>();

    public DatabaseImpl(String name) {
        this.name = name;
    }

    public Table getTable(String name){
        return tables.get(name);
    }

    @Override
    public Table createTable(String name, List<Column> columns) {
        if(tables.containsKey(name)){
            throw new RuntimeException("Table exists");
        }
        Table table = TableImpl.builder()
                .columns(columns)
                .data(new ArrayList<>())
                .name(name)
                .build();
        tables.put(name, table);
        return table;
    }
}
