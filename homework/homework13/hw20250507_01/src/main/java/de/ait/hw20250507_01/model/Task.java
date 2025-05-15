package de.ait.hw20250507_01.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    private Long id;
    private String description;
    private String priority;
}
