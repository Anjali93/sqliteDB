package interfaces;

import java.util.List;

public interface Table {
    void insert(List<Object> row);
    void printall();
    void delete(List<Object> row);
    void filter(String filter);
    List<List<Object>> fetchData();
}
