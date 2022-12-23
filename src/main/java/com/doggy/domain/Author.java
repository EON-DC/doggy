package com.doggy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Integer id;
    private String firstName;
    private String lastName;

    public String fullName() {
        return firstName + " " + lastName;
    }
}
