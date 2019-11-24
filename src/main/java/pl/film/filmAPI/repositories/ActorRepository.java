package pl.film.filmAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.film.filmAPI.model.ActorEntity;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long>{

    Optional<ActorEntity> findOneByPrimaryName(String primaryName);
}
