package com.yega.mlc.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yega.mlc.constants.EnumFieldQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldQueryDTO {
    private String fieldName;
    private Object value;
    private EnumFieldQuery comparator;
}
