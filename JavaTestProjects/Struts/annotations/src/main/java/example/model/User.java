package example.model;

public class User {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name; // TEMPLATE ENGINE OUTPUT
    }

    public void setName(String name) { // SOURCE
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: " + // TEMPLATE ENGINE OUTPUT
                "name='" + name + '\'' +
                ", age=" + age;
    }
}
