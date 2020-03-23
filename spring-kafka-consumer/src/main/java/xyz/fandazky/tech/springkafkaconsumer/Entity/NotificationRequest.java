package xyz.fandazky.tech.springkafkaconsumer.Entity;

import java.io.Serializable;

public class NotificationRequest implements Serializable {

    private String channel;

    private String message;

    /**
     * Getter method for property channel.
     *
     * @return property value of channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Setter method for property channel.
     *
     * @param channel value to be assigned to property channel
     */

    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Getter method for property message.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property message.
     *
     * @param message value to be assigned to property message
     */

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "channel='" + channel + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}