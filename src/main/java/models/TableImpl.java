package models;

import enums.DataType;
import interfaces.Table;
import interfaces.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import validators.IntValidator;
import validators.StringValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableImpl implements Table {

    private String name;
    private List<Column>  columns;
    private List<List<Object>> data = new ArrayList<>();

    private static Map<DataType, Validator> defaultValidators = new HashMap<DataType, Validator>(){{
        put(DataType.INT, new IntValidator());
        put(DataType.STRING, new StringValidator());
    }};

    public void insert(List<Object> row) {

        for (int i = 0; i < columns.size(); i++) {
            if(!defaultValidators.get(columns.get(i).getType()).check(this, row.get(i), columns.get(i), i)){
                throw new RuntimeException("Default validators failed");
            }
            int finalI = i;
            boolean otherValidations = columns.get(i).getValidators().stream().allMatch(val -> {
                return val.check(this, row.get(finalI), columns.get(finalI), finalI);
            });
            if(!otherValidations){
                throw new RuntimeException("Validation failed");
            }
        }
        data.add(row);
    }

    public void printall() {
        columns.stream().forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n");
        data.stream().forEach(row -> {
            row.stream().forEach(e -> System.out.print(e + "\t"));
        });
    }

    public void delete(List<Object> row) {

    }

    public void filter(String filter) {

    }

    @Override
    public List<List<Object>> fetchData(){
        return data;
    }


}
