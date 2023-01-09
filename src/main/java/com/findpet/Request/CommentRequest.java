package com.findpet.Request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentRequest {
    private String commentBody;
    private Integer adoptionOfferId;
    private Integer userId;
}
