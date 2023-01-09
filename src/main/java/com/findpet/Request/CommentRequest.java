package com.findpet.Request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequest {
    private String commentBody;
    private Integer adoptionOfferId;
}
