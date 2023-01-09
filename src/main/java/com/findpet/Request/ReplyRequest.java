package com.findpet.Request;


import com.findpet.Entity.Comment;
import com.findpet.Entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReplyRequest {

    private String replyBody;
    private Integer commentId;
    private Integer userId;

}
