package com.findpet.Request;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdoptionOfferRequest {

    private String title;

    private String description;

    private String city;

    private Integer daysNumber;

    private Float price;

    private Integer userId;

    private String petsIds;
}
