package ru.kpfu.itis.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String secondName;
}
