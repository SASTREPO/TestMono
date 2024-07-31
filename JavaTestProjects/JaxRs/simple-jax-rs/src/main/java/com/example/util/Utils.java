package com.example.util;

import com.example.config.Constants;

public class Utils {

    public static boolean allowedUser(String username) {
        return Constants.allowedUsers.contains(username.toLowerCase());
    }

    private Utils() {
    }
}
