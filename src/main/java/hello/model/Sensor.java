package hello.model;

import javax.persistence.*;

/**
 * Created by serg on 20-Jul-18.
 */
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "text_id")
    private String textId;

    @Column(name = "title")
    private String title;

    public Sensor() {
    }

    public Sensor(String id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
