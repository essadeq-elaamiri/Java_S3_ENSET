package mySerializableClass;

import java.io.Serializable;

public class Emloyee implements Serializable {
    private static final long serialID = 1l; // not serialized
    private int num;
    private String fullName;
    private int age;
    private Diploma diploma;
    private transient float salary; // ignored

    /*
    Note that static fields belong to a class (as opposed to an object) and are not serialized.
    Also, note that we can use the keyword transient to ignore class fields during serialization:
     */
    public Emloyee(int num, String fullName, int age, Diploma diploma, float salary) {
        this.num = num;
        this.fullName = fullName;
        this.age = age;
        this.diploma = diploma;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public void setDiploma(Diploma diploma) {
        this.diploma = diploma;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "num=" + num +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", " + diploma.toString() +
                '}';
    }
}
