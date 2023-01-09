package com.findpet.Services;


import com.findpet.Dto.CommentDto;
import com.findpet.Dto.ReplyDto;
import com.findpet.Entity.AdoptionOffer;
import com.findpet.Entity.Comment;
import com.findpet.Entity.Reply;
import com.findpet.Entity.User;
import com.findpet.Repository.CommentRepository;
import com.findpet.Repository.ReplyRepository;
import com.findpet.Request.CommentRequest;
import com.findpet.Request.ReplyRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    public ReplyDto saveReply(ReplyRequest replyRequest) {

        // Fill the Reply entity by request
        Reply reply = new Reply();
        BeanUtils.copyProperties(replyRequest, reply);

        // find the user and comment in DB from the ids in the request and set them into reply object
        User user = userService.getUser(replyRequest.getUserId());
        Comment comment = commentService.getComment(replyRequest.getCommentId());

        reply.setUser(user);
        reply.setComment(comment);

        //save the new reply in DB
        Reply newReply = replyRepository.save(reply);

        //fill the replyDao by newReply information needed
        ReplyDto replyDto = new ReplyDto();
        BeanUtils.copyProperties(newReply,replyDto);
        return replyDto;
    }
}
