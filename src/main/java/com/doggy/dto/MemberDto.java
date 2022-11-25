package com.doggy.dto;

import com.doggy.domain.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long id;

    private String username;
    private String password;
    private String email;

    private MemberRole role;
    private LocalDateTime createdOn;



}
