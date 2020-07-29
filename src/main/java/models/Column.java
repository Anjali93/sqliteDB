package models;

import enums.DataType;
import interfaces.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Column {
    private String name;
    private DataType type;
    private List<Validator> validators;
}
