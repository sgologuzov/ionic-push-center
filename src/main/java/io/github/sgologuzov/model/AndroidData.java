package io.github.sgologuzov.model;

/**
 * Created by gologuzov on 07.06.15.
 */
public class AndroidData {
    private String collapseKey;
    private boolean delayWhileIdle;
    private int timeToLive;
    private AndroidPayload payload;

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public boolean isDelayWhileIdle() {
        return delayWhileIdle;
    }

    public void setDelayWhileIdle(boolean delayWhileIdle) {
        this.delayWhileIdle = delayWhileIdle;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public AndroidPayload getPayload() {
        return payload;
    }

    public void setPayload(AndroidPayload payload) {
        this.payload = payload;
    }
}
