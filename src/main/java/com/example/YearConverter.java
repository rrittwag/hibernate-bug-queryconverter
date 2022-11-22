package com.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class YearConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getYear();
    }

    @Override
    public Year convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Year.from(dbData);
    }
}
