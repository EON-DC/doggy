package com.doggy.converter;

import com.doggy.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CategoryConverterTest {

    @Autowired
    CategoryToStringConverter categoryConverter;

    @Test
    @DisplayName("String 객체로 convert 가능해야함")
    void tdd_for_convertCategoryToString() throws Exception{
        // given
        Category category = new Category("INSANE_BOOK");
        String result = categoryConverter.convert(category);
        // when

        // then
        assertThat(result).isEqualTo(category.getName());

    }


}