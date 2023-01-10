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
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest){

        if(commentService.saveComment(commentRequest)!=null){
            return ResponseEntity.ok("Comment added successfully");
        }else {
            return ResponseEntity.ok("Comment error");
        }
    }
}
