package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feedBacks")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FeedBack {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "feedBack_id")
    private Integer id;

    private Integer Raiting;

    private String Body;

    private Integer Creator;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
