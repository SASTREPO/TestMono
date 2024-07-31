package io.mend.action;

import com.opensymphony.xwork2.ActionSupport;
import io.mend.model.MessageStore;
import io.mend.model.User;
import io.mend.service.SearchUser;

public class Search extends ActionSupport {

    private MessageStore messageStore;
    private User user;

    public String execute() throws Exception {
        messageStore = new MessageStore();

        User dbUser = SearchUser.getUserByNameUnsafe(user.getName());

        if (dbUser != null) {
            messageStore.setMessage(dbUser.toString());
        } else {
            messageStore.setMessage("User not found");
        }

        return SUCCESS;
    }

    public String input() throws Exception {
        return INPUT;
    }

    public String cancel() throws Exception {
        return SUCCESS;
    }

    public void validate(){
        if (user.getName().length() == 0) {
            addFieldError("user.name", "Name is required.");
        }
        else if (user.getName().contains("@")) {
            addFieldError("user.name", "Name should not contain @ character. " + user.getName());
        } else if (!user.getName().equalsIgnoreCase("nury") && !user.getName().equalsIgnoreCase("james")){
            addFieldError("user.name", "Invalid name");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
}
