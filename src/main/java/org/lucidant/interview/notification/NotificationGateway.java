package org.lucidant.interview.notification;

public interface NotificationGateway {

    void send(String recipient, String message);
}
