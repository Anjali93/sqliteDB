package interfaces;

import models.Column;

import java.util.List;

public interface Validator {
    boolean check(Table table, Object data, Column column, int index);
}
