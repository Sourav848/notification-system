package com.git.notificationsystem.services;

import com.git.notificationsystem.Model.Notification;
import com.git.notificationsystem.Model.NotificationRequest;

public interface INotificationService {

    Notification sendNotificationViaCommunicationChannel(NotificationRequest notificationRequest);
}
