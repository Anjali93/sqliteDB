package validators;

import interfaces.Table;
import interfaces.Validator;
import models.Column;

public class UniqueValidator implements Validator {
    @Override
    public boolean check(Table table, Object data, Column column, int index) {
        boolean res = table.fetchData().stream().noneMatch(row -> row.get(index).equals(data));
        if(!res){
            System.out.println("Unique constrain failed " + data + " : " + column);
        }
        return res;
    }
}
