package com.git.notificationsystem.services;

import com.git.notificationsystem.Model.*;
import com.git.notificationsystem.Repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    NotificationServiceFactory notificationServiceFactory;
    INotificationRepository notificationRepository;
    private Logger logger;


    @Override
    public Notification sendNotificationViaCommunicationChannel(NotificationRequest notificationRequest) {

        INotificationHandler notificationHandler = notificationServiceFactory.getChannelHandler(notificationRequest);
       if (notificationHandler.send(notificationRequest))
           logger.info("Notification has dispatched...");

        Notification notification = new Notification();
        notification.setContent(notificationRequest.getContent());
         if (notificationRequest.getSmsNotification() != null && notificationRequest.getSmsNotification().getMode().equals(Mode.SMS)) {
             SMSNotification smsNotification = new SMSNotification();
             smsNotification.setMode(notificationRequest.getSmsNotification().getMode());
             smsNotification.setRecipients(notificationRequest.getSmsNotification().getRecipients());
             notification.setSmsNotification(smsNotification);
        } else if(notificationRequest.getWhatsAppNotification() != null && notificationRequest.getWhatsAppNotification().getMode().equals(Mode.WHATSAPP)) {
             WhatsAppNotification whatsAppNotification = new WhatsAppNotification();
             whatsAppNotification.setMode(notificationRequest.getWhatsAppNotification().getMode());
             whatsAppNotification.setRecipients(notificationRequest.getWhatsAppNotification().getRecipients());
             notification.setWhatsAppNotification(whatsAppNotification);
         } else if(notificationRequest.getEmailNotification() != null && notificationRequest.getEmailNotification().getMode().equals(Mode.EMAIL)) {
             EmailNotification emailNotification = new EmailNotification();
             emailNotification.setMode(notificationRequest.getEmailNotification().getMode());
             //emailNotification.setRecipient(notificationRequest.getEmailNotification().getRecipient());
             emailNotification.setTo(notificationRequest.getEmailNotification().getTo());
             if (notificationRequest.getEmailNotification().getCc() != null)
               emailNotification.setCc(notificationRequest.getEmailNotification().getCc());
             if (notificationRequest.getEmailNotification().getBcc() != null)
               emailNotification.setBcc(notificationRequest.getEmailNotification().getBcc());

             notification.setEmailNotification(emailNotification);
         }
        return notificationRepository.save(notification);
    }

}
