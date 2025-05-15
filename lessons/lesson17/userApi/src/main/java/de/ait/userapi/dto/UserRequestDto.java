package de.ait.userapi.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
}
