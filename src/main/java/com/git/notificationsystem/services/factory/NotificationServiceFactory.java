package com.git.notificationsystem.services.factory;

import com.git.notificationsystem.Model.Mode;
import com.git.notificationsystem.Model.NotificationRequest;
import com.git.notificationsystem.services.INotificationHandler;
import com.git.notificationsystem.services.handler.EmailHandlerImpl;
import com.git.notificationsystem.services.handler.SMSHandlerImpl;
import com.git.notificationsystem.services.handler.WhatsAppHandlerImpl;
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
