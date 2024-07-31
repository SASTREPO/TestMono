package example.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import example.model.User;
import example.service.SearchUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoodTeacher extends Teacher implements Action, ParameterNameAware {

    private static final Logger log = LogManager.getLogger(Student.class);

    @org.apache.struts2.convention.annotation.Action("good-teacher-input")
    public String input() throws Exception {

        log.info("In input method of class GoodTeacher");

        return INPUT;
    }

    @Override
    public String execute() throws Exception {
        log.info("In execute method of class GoodTeacher");

        User dbUser = SearchUser.getUserByNameUnsafe(getName());

        if (dbUser != null) {
            log.debug("User found");
        } else {
            log.debug("User not found");
        }

        User dbUserIgnored = SearchUser.getUserByNameUnsafe(getIgnored());

        if (dbUserIgnored != null) {
            log.debug("User found");
        } else {
            log.debug("User not found");
        }

        return SUCCESS;
    }

    @Override
    public boolean acceptableParameterName(String parameterName) {
        boolean allowedParameterName = true ;

        if ( parameterName.contains("session")  || parameterName.contains("request")  || parameterName.contains("ignored") ) {
            allowedParameterName = false ;
        }

        return allowedParameterName;
    }
}
