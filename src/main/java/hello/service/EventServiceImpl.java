package hello.service;

import hello.model.Event;
import hello.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Integer id) {
        Event res;
        try {
            res = eventRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
