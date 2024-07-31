package example.model;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public String getFirstName() {
        return firstName; // TEMPLATE ENGINE OUTPUT
    }

    public void setFirstName(String firstName) { // SOURCE
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName; // TEMPLATE ENGINE OUTPUT
    }

    public void setLastName(String lastName) { // SOURCE
        this.lastName = lastName;
    }

    public String getEmail() {
        return email; // TEMPLATE ENGINE OUTPUT
    }

    public void setEmail(String email) { // SOURCE
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "First Name: " + getFirstName() + " Last Name:  " + getLastName() + // TEMPLATE ENGINE OUTPUT
                " Email:      " + getEmail() + " Age:      " + getAge();
    }
}
