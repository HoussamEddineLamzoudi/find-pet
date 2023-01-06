package com.findpet.Request;

import lombok.*;

@Getter
@Setter
@ToString
public class PetRequest {

    private String petName;

    private String type;

    private String description;

    private String pictures;

    private Integer owner;

}
