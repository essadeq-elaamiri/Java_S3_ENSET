package mySerializableClass;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Diploma implements Serializable {
    private int id;
    private String name;
    private LocalDateTime date;
    private int numberOfYears;

    public Diploma(int id, String name, LocalDateTime date, int numberOfYears) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.numberOfYears = numberOfYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    @Override
    public String toString() {
        return "Diploma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", numberOfYears=" + numberOfYears +
                '}';
    }
}
