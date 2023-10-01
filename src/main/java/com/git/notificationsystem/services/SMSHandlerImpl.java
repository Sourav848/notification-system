package com.git.notificationsystem.services;

import com.git.notificationsystem.Model.NotificationRequest;

public class SMSHandlerImpl implements INotificationHandler {

    @Override
    public boolean send(NotificationRequest notificationRequest) {
     //using kafka to dispatch messages for whatsapp
        return false;
    }
}
