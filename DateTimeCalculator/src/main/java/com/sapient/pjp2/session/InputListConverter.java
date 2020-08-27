package com.sapient.pjp2.session;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputListConverter implements AttributeConverter<List<Object>, String> {
    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        List<String> list = objects.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(",", list);
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        return new ArrayList<>(Arrays.asList(s.split(",")));
    }
}
