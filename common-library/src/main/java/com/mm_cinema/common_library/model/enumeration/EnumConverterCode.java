package com.mm_cinema.common_library.model.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public abstract class EnumConverterCode<T extends Enum<T> & PersistableEnum> implements AttributeConverter<T, Integer> {

    private final Class<T> enumClass;

    protected EnumConverterCode(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public Integer convertToDatabaseColumn(T attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public T convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        for (T constant : enumClass.getEnumConstants()) {
            if (constant.getValue() == dbData) {
                return constant;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + dbData + " for enum " + enumClass.getName());
    }
}