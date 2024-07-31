package io.mend.action;

import io.mend.service.SearchUser;

public class Login extends ExampleSupport {

    public String execute() {

        if (isInvalid(getUsername())) return INPUT;

        if (isInvalid(getPassword())) return INPUT;

        SearchUser.getUserByNameUnsafe(getUsername());
        SearchUser.getUserByNameUnsafe(getPassword());

        return SUCCESS;
    }

    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

    private String username;

    public String getUsername() {
        return username; // TEMPLATE ENGINE OUTPUT
    }

    public void setUsername(String username) { // SOURCE
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password; // TEMPLATE ENGINE OUTPUT
    }

    public void setPassword(String password) { // SOURCE
        this.password = password;
    }

}
