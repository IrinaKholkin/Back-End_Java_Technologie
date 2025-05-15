package de.ait.userapi.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString

public class ProductResponseDto {
    private Long id;
    private String title;
    private BigDecimal price;

}
