package io.github.sgologuzov.model;

/**
 * Created by gologuzov on 07.06.15.
 */
public class PushRequest {
    private String[] tokens;
    private Notification notification;

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
