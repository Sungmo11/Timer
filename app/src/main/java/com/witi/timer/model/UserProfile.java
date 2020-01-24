package com.witi.timer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserProfile {

    private Long profile_no;
    private Long account_no;
    private String school;
    private String grade;
    private String major;
    private int subject1;
    private int subject2;

    @Builder
    public UserProfile(Long profile_no, Long account_no, String school, String grade,
                       String major, int subject1, int subject2){
        this.profile_no = profile_no;
        this.account_no = account_no;
        this.school = school;
        this.grade = grade;
        this.major = major;
        this.subject1 = subject1;
        this.subject2 = subject2;
    }

}
