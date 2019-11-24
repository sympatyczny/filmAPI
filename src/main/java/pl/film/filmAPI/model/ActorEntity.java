package pl.film.filmAPI.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "T_ACTORS")
public class ActorEntity {

    private static final String GENERATOR_NAME = "actor.generator";

    @Id
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = "seq_actors", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRIMARY_NAME")
    private String primaryName;

    @Column(name="BIRTH_YEAR")
    private Integer birthYear;

    @Column(name="DEATH_YEAR")
    private Integer deathYear;
/*
    @Column(name = "PRIMARY_PROFESSION")
    private String primaryProfession;
*/
    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @Column(name = "USER_CREATED")
    private String userCreated;

    @Version
    @Column(name = "ENTITY_VERSION")
    private Integer entityVersion;

    @PrePersist
    void onPrePersist() {
        dateCreated = LocalDateTime.now();
        userCreated = "SERVICE";
    }
}
