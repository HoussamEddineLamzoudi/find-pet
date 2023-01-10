package com.findpet.Controller;


import com.findpet.Dto.ReplyDto;
import com.findpet.Request.ReplyRequest;
import com.findpet.Services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody ReplyRequest replyRequest){

        if(replyService.saveReply(replyRequest)!=null){
            return ResponseEntity.ok("reply added successfully");
        }else {
            return ResponseEntity.ok("reply error");
        }
    }
}
