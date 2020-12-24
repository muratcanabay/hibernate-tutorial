package io.github.muratcanabay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PLAKA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plaka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Araba araba;
}
