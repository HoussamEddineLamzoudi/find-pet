package com.findpet.Controller;


import com.findpet.Dto.CommentDto;
import com.findpet.Request.CommentRequest;
import com.findpet.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest){

        CommentDto commentDto = commentService.saveComment(commentRequest);
        return ResponseEntity.ok(commentDto.getCommentBody());
    }
}