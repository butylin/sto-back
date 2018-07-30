package hello.model;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public class Rule {

    private String name;
    private List<StartEvent> startEvents;
    private Condition condition;
    private Event action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StartEvent> getStartEvents() {
        return startEvents;
    }

    public void setStartEvents(List<StartEvent> startEvents) {
        this.startEvents = startEvents;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Event getAction() {
        return action;
    }

    public void setAction(Event action) {
        this.action = action;
    }
}
