package hello.model;

/**
 * Created by serg on 20-Jul-18.
 */
public class Sensor {
    private String id;
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

    @Override
    public String toString() {
        return "Sensor{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
