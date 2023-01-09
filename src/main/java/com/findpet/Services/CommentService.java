package com.findpet.Services;


import com.findpet.Repository.CommentRepository;
import com.findpet.Request.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void saveComment(CommentRequest commentRequest) {
//        commentRequest.get
    }
}
