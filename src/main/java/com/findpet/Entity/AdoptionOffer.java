package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adoption-offers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AdoptionOffer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "offer_id")
    private Integer id;
    private String title ;
    private String description;
    private String city;
    private Integer daysNumber = 1;
    private Float price ;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable (name = "T_pet_offers",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    @ToString.Exclude
    private List<Pet> pets = new ArrayList<>();

    @OneToMany (targetEntity = Comment.class, mappedBy = "adoptionOffer")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdoptionOffer that = (AdoptionOffer) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
