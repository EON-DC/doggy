package com.doggy.converter;

import com.doggy.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryToStringConverter implements Converter<Category, String> {
    @Override
    public String convert(Category source) {
        return source.getName();
    }
}
