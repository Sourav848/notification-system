package com.git.notificationsystem.services;

import com.git.notificationsystem.Model.NotificationRequest;

public interface INotificationHandler {

    boolean send(NotificationRequest notificationRequest);

}
