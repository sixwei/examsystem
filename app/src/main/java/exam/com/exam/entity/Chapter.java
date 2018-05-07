package exam.com.exam.entity;

/**
 * Created by gzw on 2018/4/28.
 */

public class Chapter {

    private int id;
    private String description;

    public Chapter() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
