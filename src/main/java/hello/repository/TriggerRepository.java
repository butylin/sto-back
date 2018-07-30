package hello.repository;

import hello.model.Rule;
import hello.model.StartEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by serg on 2018-07-30.
 */

@Repository
public class TriggerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createStart(Integer ruleId, Rule rule){
        String triggerName = String.format("RULE_%s_START", ruleId);
        final String CREATE_TRIGGER_BEGIN =
                "CREATE TRIGGER `%s`.`%s`\nAFTER INSERT ON `%s`\nFOR EACH ROW\n" +
                        "BEGIN\n\t";
        final String MONITORED = "SELECT monitored FROM rules WHERE id=%d INTO @monitored;";
        final String AND = " AND\n";
        StringBuilder triggerBuilder = new StringBuilder();

        List<StartEvent> predefinedEvents = filterEventsByType(rule.getStartEvents(), "predefined");
        List<StartEvent> averageEvents = filterEventsByType(rule.getStartEvents(), "average");
        List<StartEvent> simpleEvents = filterEventsByType(rule.getStartEvents(), "simple");

        if(!predefinedEvents.isEmpty()){
            triggerBuilder.append(String.format(CREATE_TRIGGER_BEGIN, "sto", triggerName, "predefined_events_track"));
            triggerBuilder.append(String.format(MONITORED, ruleId));

            if(!averageEvents.isEmpty() || !simpleEvents.isEmpty()){
                triggerBuilder.append("SELECT MAX(id) FROM sensor_data INTO @sid;\n");
            }

            triggerBuilder.append("\tIF(\n");
            triggerBuilder.append("(@monitored = 0)");
            triggerBuilder.append(AND);

            Iterator<StartEvent> iter = predefinedEvents.iterator();
            while (iter.hasNext()){
                triggerBuilder.append(getStartEventTriggerForPredefined(iter.next()));
                if(iter.hasNext() || (!simpleEvents.isEmpty()) || (!averageEvents.isEmpty()))
                    triggerBuilder.append(AND);
            }

            iter = simpleEvents.iterator();
            while(iter.hasNext()){
                triggerBuilder.append(getSimpleEventAfterPredefined(iter.next()));
                if(iter.hasNext() || (!averageEvents.isEmpty()))
                    triggerBuilder.append(AND);

            }


            iter = averageEvents.iterator();
            while(iter.hasNext()){
                triggerBuilder.append(getAverageEventAfterPredefined(iter.next()));
                if(iter.hasNext())
                    triggerBuilder.append(AND);
            }
        }else{
            triggerBuilder.append(String.format(CREATE_TRIGGER_BEGIN, "sto", triggerName, "sensor_data"));
            triggerBuilder.append("\tIF(\n");
            triggerBuilder.append("(@monitored = 0)");
            triggerBuilder.append(AND);

            Iterator<StartEvent> iter = simpleEvents.iterator();

            while(iter.hasNext()){
                triggerBuilder.append(getSimpleEvent(iter.next()));
                if(iter.hasNext() || (!averageEvents.isEmpty()))
                    triggerBuilder.append(AND);
            }

            iter = averageEvents.iterator();

            while(iter.hasNext()){
                triggerBuilder.append(getAverageEvent(iter.next()));
                if(iter.hasNext())
                    triggerBuilder.append(AND);
            }

        }
//        =================== ACTION =========================
        triggerBuilder.append("\n\t)");

        triggerBuilder.append("\n\tTHEN CALL fire_event(NEW.time_stamp, 1, NEW.id);");
        triggerBuilder.append("\n\tEND IF;");

        triggerBuilder.append("\nEND;");






        return triggerBuilder.toString();

        //saveTrigger(triggerBuilder.toString());
    }

    public void saveTrigger(String trigger){
        jdbcTemplate.execute(trigger);
        System.out.println("Trigger created");

    }

    private List<StartEvent> filterEventsByType(List<StartEvent> startEvents, String filter) {
        return startEvents.stream()
                .filter(startEvent -> startEvent.getType().equals(filter))
                .collect(Collectors.toList());
    }

    private boolean hasAverage(List<StartEvent> afterPredefinedEvents) {
        return !afterPredefinedEvents.stream()
                .filter(startEvent -> startEvent.getType().equals("average"))
                .collect(Collectors.toList())
                .isEmpty();
    }

    private boolean hasPredefined(List<StartEvent> startEvents) {
        return startEvents.stream()
                .map(StartEvent::getType)
                .collect(Collectors.toList()).contains("predefined");
    }

    private StringBuilder getSimpleEvent(StartEvent startEvent) {
        String param = startEvent.getSelectedParameter().getTextId();
        String operator = startEvent.getOperator();
        Integer value = startEvent.getValue();
        final String SIMPLE_EVENT_PATTERN = "\t\t(NEW.%s %s %d) "; // if param > value

        return new StringBuilder().append(String.format(SIMPLE_EVENT_PATTERN, param , operator, value));
    }

    private StringBuilder getAverageEvent(StartEvent startEvent) {
        String param = startEvent.getSelectedParameter().getTextId();
        String operator = startEvent.getOperator();
        Integer value = startEvent.getValue();
        Integer period = startEvent.getPeriod();
        final String AVERAGE_EVENT_PATTERN = "\t\t(NEW.id %4$s (SELECT AVG(%1$s) FROM sensor_data WHERE id > " +
                "(NEW.%1$s - %2$d) AND id < NEW.id) + %3$d)";

        return new StringBuilder().append(String.format(AVERAGE_EVENT_PATTERN, param, period, value, operator));
    }


    private StringBuilder getStartEventTriggerForPredefined(StartEvent startEvent){
        final String PREDEFINED_EVENT_PATTERN = "\t\t(NEW.%s = 1)";
        String param = startEvent.getSelectedParameter().getTextId();

        return new StringBuilder().append(String.format(PREDEFINED_EVENT_PATTERN, param));
    }

    private StringBuilder getAverageEventAfterPredefined(StartEvent startEvent){
        String param = startEvent.getSelectedParameter().getTextId();
        String operator = startEvent.getOperator();
        Integer period = startEvent.getPeriod();
        Integer value = startEvent.getValue();
        final String AVERAGE_EVENT_PATTERN = "\t\t((SELECT %1$s FROM sensor_data WHERE id = @sid LIMIT 1) %4$s (SELECT AVG(%1$s) FROM sensor_data WHERE id > " +
                "(@sid - %2$d) AND id < @sid) + %3$d)";

        return new StringBuilder().append(String.format(AVERAGE_EVENT_PATTERN, param, period, value, operator));
    }

    private StringBuilder getSimpleEventAfterPredefined(StartEvent startEvent) {
        String param = startEvent.getSelectedParameter().getTextId();
        String operator = startEvent.getOperator();
        Integer value = startEvent.getValue();
        final String SIMPLE_EVENT_PATTERN = "\t\t((SELECT %s FROM sensor_data WHERE id = @sid) %s %d )";

        return new StringBuilder(String.format(SIMPLE_EVENT_PATTERN, param, operator, value));
    }


}
