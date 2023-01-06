package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id")
    private Integer id;

    @Column(columnDefinition="TEXT")
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private AdoptionOffer adoptionOffer;

//    @OneToMany (targetEntity = Reply.class, mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comment comment = (Comment) o;
        return id != null && Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
