package example.actions;

public class Teacher {
    private String name;
    private String ignored;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name; // TEMPLATE ENGINE OUTPUT
    }

    public void setName(String name) { // SOURCE
        this.name = name;
    }

    public String getIgnored() {
        return ignored; // TEMPLATE ENGINE OUTPUT
    }

    public void setIgnored(String ignored) { // SOURCE: ignored in GoodTeacher
        this.ignored = ignored;
    }

    @Override
    public String toString() {
        return "Teacher{" + // TEMPLATE ENGINE OUTPUT
                "name='" + name + '\'' +
                '}';
    }
}
