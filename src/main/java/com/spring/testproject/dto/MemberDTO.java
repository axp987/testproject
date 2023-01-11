package com.spring.testproject.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private String name;
    private String email;
    private String organization;

    private String age;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
