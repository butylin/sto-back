package hello.model;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
public class ComplexCondition {
    private List<Param> parameters;
    private Integer threshold;
    private String strategy;

    public List<Param> getParameters() {
        return parameters;
    }

    public void setParameters(List<Param> parameters) {
        this.parameters = parameters;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
