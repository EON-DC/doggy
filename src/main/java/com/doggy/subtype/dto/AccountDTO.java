package com.doggy.subtype.dto;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.domain.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
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

    public AccountDTO(Long id, String loginId, String loginPw, String profileName, String email, Integer profileImageCode, Role role, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.profileName = profileName;
        this.email = email;
        this.profileImageCode = profileImageCode;
        this.role = role;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Account mapperDTOToAccount() {
        return  Account.builder()
                .id(this.getId())
                .loginId(this.getLoginId())
                .loginPw(this.getLoginPw())
                .profileName(this.getProfileName())
                .email(this.getEmail())
                .build();
     
    }

    public AccountDTO mapperAccountToDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .loginId(account.getLoginId())
                .loginPw(account.getLoginPw())
                .profileName(account.getProfileName())
                .email(account.getEmail())
                .profileImageCode(account.getProfileImageCode())
                .role(account.getRole())
                .createdDate(account.getCreatedDate())
                .lastModifiedDate(account.getLastModifiedDate())
                .build();
    }
}
