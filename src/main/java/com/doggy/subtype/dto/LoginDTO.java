package com.doggy.subtype.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
    @NotNull
    private String loginId;
    @NotNull
    private String loginPw;
}
