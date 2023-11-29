package ru.kpfu.itis.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Booking {
    private Integer id;
    private Integer userId;
    private Integer photoStudioId;
    private String date;
}
