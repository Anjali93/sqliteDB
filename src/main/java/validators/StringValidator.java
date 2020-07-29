package validators;

import interfaces.Table;
import interfaces.Validator;
import models.Column;

public class StringValidator implements Validator {

    @Override
    public boolean check(Table table, Object data, Column column, int index) {
        if(!(data instanceof String)){
            return false;
        }
        if(((String) data).length() > 20){
            return false;
        }
        return true;
    }
}
