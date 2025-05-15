package de.ait.hw20250513_01.model;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@Setter
public class Task {
    private Long id;
    private String description;
    private Priority priority;


}