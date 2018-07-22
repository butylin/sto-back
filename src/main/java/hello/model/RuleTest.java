package hello.model;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public class RuleTest {
    //private List<Object> startEvents;
    private List<StartEvent> startEvents;

    public List<StartEvent> getStartEvents() {
        return startEvents;
    }

    public void setStartEvents(List<StartEvent> startEvents) {
        this.startEvents = startEvents;
    }

    @Override
    public String toString() {
        return "RuleTest{" +
                "startEvents=" + startEvents +
                '}';
    }
}
