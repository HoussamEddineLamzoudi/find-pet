package com.findpet.Dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class PetDto {

    private Integer id;

    private String petName;

    private String type;

    private String description;

    private String pictures;

}
