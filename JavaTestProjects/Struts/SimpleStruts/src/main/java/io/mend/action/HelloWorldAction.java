package io.mend.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import io.mend.model.MessageStore;
import io.mend.service.SearchUser;

public class HelloWorldAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private MessageStore messageStore;
    private static int helloCount = 0;
    
    public int getHelloCount() {
        return helloCount;
    }

    public void setHelloCount(int helloCount) {
        HelloWorldAction.helloCount = helloCount;
    }
    
    private String userName;
    private String email;
    private String blocked;

    public String getUserName() {
        return userName; // TEMPLATE ENGINE OUTPUT
    }

    @Validations(requiredStrings = { @RequiredStringValidator(fieldName = "userName", type = ValidatorType.FIELD, message = "Username is required") })
    public void setUserName(String userName) { // SAFE SOURCE: Sanitized in CustomInterceptor1
        this.userName = userName;
    }

    public String getEmail() {
        return email; // TEMPLATE ENGINE OUTPUT
    }

    @EmailValidator(type = ValidatorType.FIELD, fieldName = "email", message = "Please enter valid email.")
    public void setEmail(String email) { // SAFE SOURCE: Sanitized by EmailValidator
        this.email = email;
    }

    public String execute() throws Exception {

        if(userName != null)
            SearchUser.getUserByNameUnsafe(userName);

        if(email != null)
            SearchUser.getUserByNameUnsafe(email);

        if(blocked != null)
            SearchUser.getUserByNameUnsafe(blocked);

        messageStore = new MessageStore() ;
        
        if (userName != null) {
            messageStore.setMessage( messageStore.getMessage() + " " + userName);
        }
        
        helloCount++;
        
        return SUCCESS;
    }

    public String getBlocked() {
        return blocked; // TEMPLATE ENGINE OUTPUT
    }

    public void setBlocked(String blocked) { // BLOCKED SOURCE: blocked by struts.xml
        this.blocked = blocked;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

}
