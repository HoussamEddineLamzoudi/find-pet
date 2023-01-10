package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    @Column(columnDefinition="TEXT")
    private String picture;

    private Integer animalsAdoptedNumber = 0;

    @ManyToMany
    @JoinTable (name = "T_pet_adopters",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    @ToString.Exclude
    private List<Pet> pets = new ArrayList<>();

    @OneToMany (targetEntity = AdoptionOffer.class, mappedBy = "user")
    @ToString.Exclude
    private List<AdoptionOffer> adoptionOffers = new ArrayList<>();

    @OneToMany (targetEntity = Comment.class, mappedBy = "user")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany (targetEntity = Reply.class, mappedBy = "user")
    @ToString.Exclude
    private List<Reply> replies = new ArrayList<>();

    @OneToMany (targetEntity = FeedBack.class, mappedBy = "user")
    @ToString.Exclude
    private List<FeedBack> feedBacks = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
