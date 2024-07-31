package io.mend.model;

public class MessageStore {
    
    private String message;
    
    public MessageStore() {
        setMessage("Hello Struts User");
    }

    public String getMessage() {
        return message; // TEMPLATE ENGINE OUTPUT: If requested as a property of an object from JSP file. Ex: <s:property value="messageStore.message" />
    }

    public void setMessage(String message) { // SOURCE
        this.message = message;
    }
    
    public String toString() {
        return message + " (from toString)"; // TEMPLATE ENGINE OUTPUT: If requested as an object from JSP file. Ex: <s:property value="messageStore" />
    }
}
