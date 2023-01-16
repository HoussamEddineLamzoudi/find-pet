package com.findpet.Dto;


import com.findpet.Entity.AdoptionOffer;
import com.findpet.Entity.Reply;
import com.findpet.Entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentDto {

    private Integer id;

    private String commentBody;

    private UserDto userDto;
}
