package pl.film.filmAPI.model;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ActorRepresentation {

    private String primaryName;

    private Integer birthYear;

    private Integer deathYear;

        public static ActorRepresentation of(String primaryName,  Integer birthYear, Integer deathYear) {
            return new ActorRepresentation(primaryName, birthYear, deathYear);
        }

    }

