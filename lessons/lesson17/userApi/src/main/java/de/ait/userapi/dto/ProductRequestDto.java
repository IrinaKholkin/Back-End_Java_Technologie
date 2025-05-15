package de.ait.userapi.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString

public class ProductRequestDto {
    private String title;
    private BigDecimal price;

}