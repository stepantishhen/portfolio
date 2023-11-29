package ru.kpfu.itis.entity;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Review {
    private Integer id;
    private Integer userId;
    private String text;
    private Integer rating;
    private Boolean isPublish;
}
