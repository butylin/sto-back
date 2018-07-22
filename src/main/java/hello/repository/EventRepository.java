package hello.repository;

import hello.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by serg on 21-Jul-18.
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    @Override
    Event save(Event event);

    @Override
    Optional<Event> findById(Integer integer);

    @Override
    List<Event> findAll();
}
