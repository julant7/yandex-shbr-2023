package ru.yandex.test_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import ru.yandex.test_task.entity.enums.TypeOfMovement;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "couriers")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "type_of_movement")
    private TypeOfMovement typeOfMovement;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<District> districts;

    @Column(name = "work_schedule")
    private TypeOfMovement workSchedule;

    @Column(name = "time_designation")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TimeDesignation> timeDesignation;


    public Courier() {

    }
}
