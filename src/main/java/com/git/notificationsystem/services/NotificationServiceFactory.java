package com.git.notificationsystem.services;

import com.git.notificationsystem.Model.Mode;
import com.git.notificationsystem.Model.NotificationRequest;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceFactory {

    public INotificationHandler getChannelHandler(NotificationRequest notificationRequest) {
        if (notificationRequest.getSmsNotification() != null && notificationRequest.getSmsNotification().getMode().equals(Mode.SMS))
            return new SMSHandlerImpl();
        else if(notificationRequest.getWhatsAppNotification() != null && notificationRequest.getWhatsAppNotification().getMode().equals(Mode.WHATSAPP))
            return new WhatsAppHandlerImpl();
        else if(notificationRequest.getEmailNotification() != null && notificationRequest.getEmailNotification().getMode().equals(Mode.EMAIL))
            return new EmailHandlerImpl();

     return null;
    }
}
