package hello.model;

/**
 * Created by serg on 21-Jul-18.
 */
public class StartEvent {
    private Integer colId;
    private Sensor selectedParameter;
    private String operator;
    private Integer value;
    private String strategy;
    private Integer period;
    private String logicalOperator;
    private String type;


    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public Sensor getSelectedParameter() {
        return selectedParameter;
    }

    public void setSelectedParameter(Sensor selectedParameter) {
        this.selectedParameter = selectedParameter;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StartEvent{" +
                "colId=" + colId +
                ", selectedParameter=" + selectedParameter +
                ", operator='" + operator + '\'' +
                ", value=" + value +
                ", strategy='" + strategy + '\'' +
                '}';
    }
}
