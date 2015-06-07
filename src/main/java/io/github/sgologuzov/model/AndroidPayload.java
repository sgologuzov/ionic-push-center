package io.github.sgologuzov.model;

/**
 * Created by gologuzov on 07.06.15.
 */
public class AndroidPayload extends Payload {
    private String icon;
    private String tag;
    private String color;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
