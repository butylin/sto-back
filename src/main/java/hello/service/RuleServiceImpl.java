package hello.service;

import hello.model.Rule;
import hello.model.StartEvent;
import hello.repository.RuleRepository;
import hello.repository.TriggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by serg on 2018-07-25.
 */
@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    RuleRepository ruleRepository;

    @Autowired
    TriggerRepository triggerRepository;

    @Override
    public void save(Rule rule) {
        Integer ruleId = ruleRepository.save(rule);



        String startTrigger = triggerRepository.createStart(ruleId, rule);
        triggerRepository.saveTrigger(startTrigger);
        System.out.println(startTrigger);

    }




    private StringBuilder getStartEventTrigger(StartEvent startEvent){
        final String SIMPLE_EVENT_PATTERN = "(NEW.%s %s %d) %s "; // if param > value
        final String AVERAGE_EVENT_PATTERN = "(NEW.%1$s %2$s " + // if param > (SELECT AVG(param) WHERE param.id > period)
                "(SELECT AVG(%1$s) FROM sensor_data\n" +
                "\tWHERE id > (NEW.id - %3$d) AND id < NEW.id) %4$s"; //
        String param = startEvent.getSelectedParameter().getTextId();
        String operator = startEvent.getOperator();
        String logicalOperator = startEvent.getLogicalOperator();
        Integer period = startEvent.getPeriod();
        Integer value = startEvent.getValue();

        StringBuilder builder = new StringBuilder("(");
        if(startEvent.getType().equals("simple")){
            builder.append(String.format(SIMPLE_EVENT_PATTERN, param , operator, value, logicalOperator));
        }

        if(startEvent.getType().equals("average")){
            builder.append(String.format(AVERAGE_EVENT_PATTERN, param, operator, period, logicalOperator));
        }

        if(startEvent.getType().equals("predefined")){
            builder.append("IMPOSSIBLE!");
        }

        builder.append(")");

        return builder;
    }


}
