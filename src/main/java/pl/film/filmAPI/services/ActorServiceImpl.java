package pl.film.filmAPI.services;

import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.film.filmAPI.model.ActorEntity;
import pl.film.filmAPI.model.ActorRepresentation;
import pl.film.filmAPI.model.ActorsRepresentation;
import pl.film.filmAPI.repositories.ActorRepository;

import java.util.List;

@Service
@Log
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    ModelMapper modelMapper;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Transactional
    @Override
    public void saveActors(ActorsRepresentation actorsRepresentation) {
        log.info("saveActors: "+ actorsRepresentation.toString());

        List<ActorRepresentation> actorRepresentationList = actorsRepresentation.getActorRepresentations();

        actorRepresentationList.forEach(actorRepresentation -> {

            ActorEntity actorEntity =  modelMapper.map(actorRepresentation, ActorEntity.class);

            log.info("saveActor: "+actorEntity.toString());
            actorRepository.save(actorEntity);
        });
    }

    @Transactional
    @Override
    public void saveActor(ActorRepresentation actorRepresentation) {
        log.info("saveActors: "+ actorRepresentation.toString());

        ActorEntity actorEntity =  modelMapper.map(actorRepresentation, ActorEntity.class);
        log.info("saveActor: "+actorEntity.toString());
        actorRepository.save(actorEntity);
    }
}
