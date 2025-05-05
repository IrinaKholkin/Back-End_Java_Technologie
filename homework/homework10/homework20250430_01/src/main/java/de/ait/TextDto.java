package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString

public class TextDto {
    private String data;
    private double confidence;
    private String langquage;
}
