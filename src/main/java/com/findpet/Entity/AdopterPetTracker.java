package com.findpet.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "adopter_pet_tracker")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AdopterPetTracker {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tracker_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "opet_id")
    private Pet pet;

    private LocalDate startDate;

    private LocalDate endDate;
}
