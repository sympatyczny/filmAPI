package pl.film.filmAPI;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
import pl.film.filmAPI.model.ActorRepresentation;
import pl.film.filmAPI.model.ActorsRepresentation;
import pl.film.filmAPI.repositories.ActorRepository;
import pl.film.filmAPI.services.ActorService;
import org.springframework.ui.Model;

//@RestController
@org.springframework.stereotype.Controller
@Log
@AllArgsConstructor
public class Controller {

    private final ActorRepository actorRepository;
    private final ActorService actorService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/actors")
    public String main(Model model) {
        log.info("getAllActors()");
        ActorsRepresentation actors = ActorsRepresentation.of(actorRepository.findAll());

        model.addAttribute("actors", actors.getActorRepresentations());
     return "actors";
    }

    @GetMapping("/actor")
    public String showCreateForm(Model model) {
        ActorRepresentation actor = new ActorRepresentation();

        model.addAttribute("actor", actor);
        return "actor";
    }

    @PostMapping("/actor")
    public String saveActors(@ModelAttribute ActorRepresentation actor, Model model) {
         log.info("saveActors()");
         log.info("primaryYear: " + actor.getPrimaryName()+
                  " birthYear: "+ actor.getBirthYear()+
                  " deathYear: "+actor.getDeathYear());
        actorService.saveActor(actor);

        return "result";
    }

}



