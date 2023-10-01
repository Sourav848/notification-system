package com.git.notificationsystem.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "notification")
public class Notification {

    @Id
    String id;
    String content;
    WhatsAppNotification whatsAppNotification;
    SMSNotification smsNotification;
    EmailNotification emailNotification;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WhatsAppNotification getWhatsAppNotification() {
        return whatsAppNotification;
    }

    public void setWhatsAppNotification(WhatsAppNotification whatsAppNotification) {
        this.whatsAppNotification = whatsAppNotification;
    }

    public SMSNotification getSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(SMSNotification smsNotification) {
        this.smsNotification = smsNotification;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }
}
