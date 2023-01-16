package com.findpet.Dto;


import com.findpet.Entity.Comment;
import com.findpet.Entity.Pet;
import com.findpet.Entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdoptionOfferDto {

    private Integer id;

    private String title;

    private String description;

    private String city;

    private LocalDate startDate;

    private Integer daysNumber;

    private Float price;

    private UserDto userDto;

    private List<PetDto> petList = new ArrayList<>();

    private List<CommentDto> commentList = new ArrayList<>();
}
