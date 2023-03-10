package com.findpet.Services;

import com.findpet.Dto.AdoptionOfferDto;
import com.findpet.Dto.CommentDto;
import com.findpet.Dto.PetDto;
import com.findpet.Dto.UserDto;
import com.findpet.Entity.AdoptionOffer;
import com.findpet.Entity.Comment;
import com.findpet.Entity.Pet;
import com.findpet.Entity.User;
import com.findpet.Repository.AdoptionOfferRepository;
import com.findpet.Request.AdoptionOfferRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdoptionOfferService {

    @Autowired
    AdoptionOfferRepository adoptionOfferRepository;
    @Autowired
    UserService userService;
    @Autowired
    PetService petService;


    public AdoptionOffer saveAdoptionOffer(AdoptionOfferRequest adoptionOfferRequest) {

        // Fill the adoption offer entity by request
        AdoptionOffer adoptionOffer = new AdoptionOffer();
        BeanUtils.copyProperties(adoptionOfferRequest, adoptionOffer);

        // find the user and pets in DB from the ids in the request and set them into adoptionOffer object
        User user = userService.getUser(adoptionOfferRequest.getUserId());
        List<Pet> pets = new ArrayList<>();
        String petsIds = adoptionOfferRequest.getPetsIds();
        String[] res = petsIds.split("-");
        for (String r : res) {
            Pet pet = petService.findPet(Integer.parseInt(r));
            pets.add(pet);
        }
        adoptionOffer.setUser(user);
        adoptionOffer.setPets(pets);

        //save the new adoption offer in DB
        AdoptionOffer newAdoptionOffer = adoptionOfferRepository.save(adoptionOffer);

        return newAdoptionOffer;
    }

    public AdoptionOffer getAdoptionOffer(Integer adoptionOfferId) {
        return adoptionOfferRepository.findById(adoptionOfferId).get();
    }

    //§§§§§§§§§§§§§ complit it
    public List<AdoptionOfferDto> getAllAdoptionOffers() {


        System.out.println("gett all services");
        System.out.println("-".repeat(30));
        List<AdoptionOffer> adoptionOfferList = adoptionOfferRepository.findAll();
        List<AdoptionOfferDto> adoptionOfferDtoList = new ArrayList<>();

        for (AdoptionOffer adoptionOffer : adoptionOfferList) {
            AdoptionOfferDto adoptionOfferDto = new AdoptionOfferDto();
            BeanUtils.copyProperties(adoptionOffer, adoptionOfferDto);

            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(adoptionOffer.getUser(), userDto);

            List<Comment> commentList = adoptionOffer.getComments();
            List<CommentDto> commentDtoList = new ArrayList<>();

            for (Comment comment : commentList) {
                CommentDto commentDto = new CommentDto();
                BeanUtils.copyProperties(comment, commentDto);

                UserDto userDto1 = new UserDto();
                BeanUtils.copyProperties(comment.getUser(), userDto1);
                commentDto.setUserDto(userDto1);

                commentDtoList.add(commentDto);
            }

            List<Pet> petList = adoptionOffer.getPets();
            List<PetDto> petDtoList = new ArrayList<>();

            for (Pet pet : petList) {
                PetDto petDto = new PetDto();
                BeanUtils.copyProperties(pet, petDto);

                petDtoList.add(petDto);
            }


            adoptionOfferDto.setUserDto(userDto);
            adoptionOfferDto.setPetList(petDtoList);
            adoptionOfferDto.setCommentList(commentDtoList);

            adoptionOfferDtoList.add(adoptionOfferDto);
        }

        return adoptionOfferDtoList;
    }
}
