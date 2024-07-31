package example.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class HelloAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LogManager.getLogger(HelloAction.class);

    private String message;
    private Map<String, Object> userSession;


    public String execute() throws Exception {

        log.info("In execute method of class Hello");

        message = "Hello from Struts 2 with no XML configuration.";

        userSession.put("sessionMessage", "Hello message from Session"); // SESSION SINK

        return SUCCESS;
    }


    public void setMessage(String message) { // SOURCE
        this.message = message;
    }


    public String getMessage() {
        return message; // TEMPLATE ENGINE OUTPUT
    }


    @Override
    public void withSession(Map<String, Object> session) { // SESSION SOURCE
        userSession = session;
    }
}
