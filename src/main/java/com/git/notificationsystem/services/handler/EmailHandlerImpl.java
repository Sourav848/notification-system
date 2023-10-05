package com.git.notificationsystem.services.handler;

import com.git.notificationsystem.Model.NotificationRequest;
import com.git.notificationsystem.services.INotificationHandler;

public class EmailHandlerImpl implements INotificationHandler {

    @Override
    public boolean send(NotificationRequest notificationRequest) {
       //using kafka to dispatch messages for whatsapp
    return false;
    }
}
