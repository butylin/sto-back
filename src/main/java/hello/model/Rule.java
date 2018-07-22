package hello.model;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public class Rule {

    private List<StartEvent> startEvents;
    private Condition condition;
    private Event action;

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
