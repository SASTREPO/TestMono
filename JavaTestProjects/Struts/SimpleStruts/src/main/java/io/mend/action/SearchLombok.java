package io.mend.action;

import com.opensymphony.xwork2.ActionSupport;
import io.mend.model.MessageStore;
import io.mend.model.User;
import io.mend.model.UserLombok;
import io.mend.service.SearchUser;

public class SearchLombok extends ActionSupport  {

    private MessageStore messageStore;
    private UserLombok userLombok;

    public String execute() throws Exception {
        messageStore = new MessageStore();

        User dbUser = SearchUser.getUserByNameUnsafe(userLombok.getName());

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
        if (userLombok.getName().length() == 0) {
            addFieldError("userLombok.name", "Name is required.");
        }
    }

    public UserLombok getUserLombok() {
        return userLombok;
    }

    public void setUserLombok(UserLombok userLombok) {
        this.userLombok = userLombok;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
}
