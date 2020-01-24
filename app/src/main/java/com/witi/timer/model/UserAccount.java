package com.witi.timer.model;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserAccount {

    private Long account_no;
    private String email;
    private String password;
    private String status;
    private LocalDateTime registered;
    private LocalDateTime updated;

    @Builder
    public UserAccount(Long account_no, String email, String password, String status, LocalDateTime registered, LocalDateTime updated)
    {
        this.account_no = account_no;
        this.email = email;
        this.password = password;
        this.status = status;
        this.registered = registered;
        this.updated = updated;
    }

}
