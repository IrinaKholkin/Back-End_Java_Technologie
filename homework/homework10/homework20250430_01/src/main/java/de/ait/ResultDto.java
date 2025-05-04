package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString

public class ResultDto {
    private List<TextDto> text;
}
