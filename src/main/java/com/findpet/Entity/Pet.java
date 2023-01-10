package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pets")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pet_id")
    private Integer id;

    private String petName = "my pet";

    private String type;

    private String description;

    @Column(columnDefinition="TEXT")
    private String pictures;

//    @Column(nullable = false)
//    private Integer owner;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

//    @ManyToMany
//    @JoinTable (name = "T_pet_adopters",
//            joinColumns = @JoinColumn(name = "pet_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    @ToString.Exclude
//    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinTable (name = "T_pet_offers",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id"))
    @ToString.Exclude
    private List<AdoptionOffer> adoptionOffers = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pet pet = (Pet) o;
        return id != null && Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
