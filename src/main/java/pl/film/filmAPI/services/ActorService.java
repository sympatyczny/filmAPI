package pl.film.filmAPI.services;

import org.springframework.stereotype.Service;
import pl.film.filmAPI.model.ActorRepresentation;
import pl.film.filmAPI.model.ActorsRepresentation;

@Service
public interface ActorService {

    public void saveActors(ActorsRepresentation actorsRepresentation);

    public void saveActor(ActorRepresentation actorRepresentation);

}
