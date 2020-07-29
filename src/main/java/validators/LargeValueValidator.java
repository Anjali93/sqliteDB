package validators;

import interfaces.Table;
import interfaces.Validator;
import models.Column;

public class LargeValueValidator implements Validator {
    @Override
    public boolean check(Table table, Object data, Column column, int index) {
        try{
            if((Integer) data > 1024 && (Integer) data < -1024){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
