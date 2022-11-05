package com.doggy.subtype.dto;

import com.doggy.subtype.domain.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDTO {


    private Long id;
    private String loginId;
    private String loginPw;
    private String profileName;
    private String email;
    private Integer profileImageCode;
    private Role role;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public AccountDTO() {
    }

}
