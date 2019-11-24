package pl.film.filmAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActorsRepresentation {

    private List<ActorRepresentation> actorRepresentations;

    public static ActorsRepresentation of(List<ActorEntity> actors) {
        return new ActorsRepresentation(actors.stream()
                .map(actor -> ActorRepresentation.of(actor.getPrimaryName(),
                                                     actor.getBirthYear(),
                                                     actor.getDeathYear()
                                                     ))
                .collect(Collectors.toList()));
    }

}
