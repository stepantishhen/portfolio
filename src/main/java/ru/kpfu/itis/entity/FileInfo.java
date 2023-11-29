package ru.kpfu.itis.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class FileInfo {
    private Long id;
    private String originalFileName;
    private String storageFileName;
    private Long size;
    private String type;
    private String description;
}
