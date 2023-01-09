package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "replys")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Reply {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reply_id")
    private Integer id;

    @Column(columnDefinition="TEXT")
    private String replyBody;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reply reply = (Reply) o;
        return id != null && Objects.equals(id, reply.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
