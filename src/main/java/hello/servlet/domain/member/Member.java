package hello.servlet.domain.member;

import lombok.Data;

@Data
public class Member { //entity
    private Long id;
    private String username;
    private int age;

    public Member(){ //기본 생성자

    }

    public Member(String username, int age){ //생성자
        this.username = username;
        this.age = age;
    }
}
