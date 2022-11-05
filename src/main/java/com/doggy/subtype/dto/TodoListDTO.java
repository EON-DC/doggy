package com.doggy.subtype.dto;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.domain.TodoList;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
public class TodoListDTO {

    private Long id;
    private String doing;
    private LocalDateTime createdTime;
    private Account account;

    public TodoListDTO(Long id, String doing, LocalDateTime createdTime, Account account) {
        this.id = id;
        this.doing = doing;
        this.createdTime = createdTime;
        this.account = account;
    }

}
