package ru.kpfu.itis.entity;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class PhotoStudio {
    private Integer id;
    private String title;
    private String description;
    private String address;
    private String email;
    private String phoneNumber;
}
