package com.start.mavenbook.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDTO {
    private String name;
    private String email;
    private String password;
    private String address;
}
