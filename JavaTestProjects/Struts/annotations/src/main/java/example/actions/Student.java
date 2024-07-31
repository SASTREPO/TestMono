package example.actions;

import example.model.StudentAge;
import example.model.User;
import example.service.SearchUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

public class Student extends Search {

    private static final Logger log = LogManager.getLogger(Student.class);

    private String message;
    private String name;
    private StudentAge studentAge;

    @Action("student-input")
    public String input() throws Exception {

        log.info("In input method of class Student");

        return INPUT;
    }

    public String execute() throws Exception {

        log.info("In execute method of class Student");

        User dbUser = SearchUser.getUserByNameUnsafe(getName());

        if (dbUser != null) {
            message = dbUser.toString();
            log.debug("User found");
        } else {
            message = "User not found";
            log.debug("User not found");
        }

        SearchUser.getUserByAgeSafe(studentAge);

        return SUCCESS;
    }

    public String getMessage() {
        return message; // TEMPLATE ENGINE OUTPUT
    }

    public void setMessage(String message) { // SOURCE
        this.message = message;
    }

    public String getName() {
        return name; // TEMPLATE ENGINE OUTPUT
    }

    public void setName(String name) {  // SOURCE
        this.name = name;
    }

    public StudentAge getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(StudentAge studentAge) {
        this.studentAge = studentAge;
    }
}
