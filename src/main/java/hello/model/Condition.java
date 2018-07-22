package hello.model;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public class Condition {
    private String type;
    private Integer time;

    private List<StartEvent> simpleConditions;
    private ComplexCondition complexCondition;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<StartEvent> getSimpleConditions() {
        return simpleConditions;
    }

    public void setSimpleConditions(List<StartEvent> simpleConditions) {
        this.simpleConditions = simpleConditions;
    }

    public ComplexCondition getComplexCondition() {
        return complexCondition;
    }

    public void setComplexCondition(ComplexCondition complexCondition) {
        this.complexCondition = complexCondition;
    }
}
