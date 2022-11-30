package com.doggy.converter;

import com.doggy.Category;
import org.springframework.core.convert.converter.Converter;

public class StringToCategoryConverter implements Converter<String, Category> {
    @Override
    public Category convert(String source) {
        return new Category(source);
    }
}
