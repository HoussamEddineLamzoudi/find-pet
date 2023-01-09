package com.findpet.Services;


import com.findpet.Entity.AdoptionOffer;
import com.findpet.Entity.Comment;
import com.findpet.Entity.User;
import com.findpet.Repository.CommentRepository;
import com.findpet.Request.CommentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    AdoptionOfferService adoptionOfferService;

    public Comment saveComment(CommentRequest commentRequest) {

        // Fill the Comment entity by request
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRequest, comment);

        // find the user and adoptionOffer in DB from the ids in the request and set them into comment object
        User user = userService.getUser(commentRequest.getUserId());
        AdoptionOffer adoptionOffer = adoptionOfferService.getAdoptionOffer(commentRequest.getAdoptionOfferId());

        comment.setUser(user);
        comment.setAdoptionOffer(adoptionOffer);

        //save the new comment in DB
        Comment newComment = commentRepository.save(comment);


        return newComment;
    }

    public Comment getComment(Integer commentId) {
        return commentRepository.findById(commentId).get();
    }
}
