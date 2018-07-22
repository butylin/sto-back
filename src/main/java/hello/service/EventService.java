package hello.service;

import hello.model.Event;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public interface EventService {
    Event save(Event event);
    Event findById(Integer integer);
    List<Event> findAll();
}
