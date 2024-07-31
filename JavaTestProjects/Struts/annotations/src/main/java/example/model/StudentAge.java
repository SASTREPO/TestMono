package example.model;

public class StudentAge {

    private int age;

    public StudentAge() {
    }

    public StudentAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentAge{" +
                "age=" + age +
                '}';
    }
}
