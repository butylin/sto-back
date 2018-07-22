package hello.model;

/**
 * Created by serg on 21-Jul-18.
 */
public class Param {
    private Integer colId;
    private Sensor selectedParameter;
    private String literal;

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

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }
}
