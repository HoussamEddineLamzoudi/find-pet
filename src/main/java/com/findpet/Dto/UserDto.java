package com.findpet.Dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {

    private Integer id;

    private String username;

    private String phone;

    private String picture;

    private Integer animalsAdoptedNumber;

}
