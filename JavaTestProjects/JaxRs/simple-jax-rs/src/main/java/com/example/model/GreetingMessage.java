package com.example.model;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@SuppressWarnings("serial")
@XmlRootElement(name="GreetingMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class GreetingMessage implements Serializable {

    @XmlElement(name="message")
    private String message;

    public static GreetingMessage of(String s) {
        final var message = new GreetingMessage();
        message.setMessage(s);
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
