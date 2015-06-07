package io.github.sgologuzov.model;

/**
 * Created by gologuzov on 07.06.15.
 */
public class Notification {
    private String alert;
    private AndroidData android;
    //private IOSData ios;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public AndroidData getAndroid() {
        return android;
    }

    public void setAndroid(AndroidData android) {
        this.android = android;
    }
}
