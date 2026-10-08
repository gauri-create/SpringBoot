package com.example.HibernateDemo.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply=false)
public class BooleanToStringConverter implements AttributeConverter<Boolean, String>{

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if(aBoolean == null) return null;
        return aBoolean?"Yes":"No";   
    }
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData==null) return null;

       return "Yes".equals(dbData);
    }
    
}
