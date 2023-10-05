package com.git.notificationsystem.controller;

import com.git.notificationsystem.Model.Notification;
import com.git.notificationsystem.Model.NotificationRequest;
import com.git.notificationsystem.services.INotificationService;
import com.git.notificationsystem.services.impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/notification")

public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;
    private Logger logger;

    @PostMapping ("/send")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        logger.info("Sending notification with request...");
        Notification notification = this.notificationService.sendNotificationViaCommunicationChannel(notificationRequest);
        return ResponseEntity.ok(notification);

    }

}
