package de.ait;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDto {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
