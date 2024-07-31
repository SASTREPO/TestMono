package example.actions;

import com.opensymphony.xwork2.ActionSupport;
import example.model.Person;
import example.model.User;
import example.service.SearchUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LogManager.getLogger(RegisterAction.class);

    private Person personBean;

    @Action("register-input")
    public String input() throws Exception {

        log.info("In input method of class RegisterAction");

        return INPUT;
    }

    public String execute() throws Exception {

        log.info("In execute method of class RegisterAction");

        User dbUser = SearchUser.getUserByNameUnsafe(personBean.getFirstName());

        if (dbUser != null) {
            log.debug("User found");
        } else {
            log.debug("User not found");
        }

        return SUCCESS;
    }


    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }

}
