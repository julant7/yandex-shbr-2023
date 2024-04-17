package ru.yandex.test_task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "districts")
public class District {
    @Id
    private BigInteger id;

}
