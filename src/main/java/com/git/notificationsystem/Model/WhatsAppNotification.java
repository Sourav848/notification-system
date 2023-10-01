package com.git.notificationsystem.Model;

import java.util.List;

public class WhatsAppNotification {

    String mode = String.valueOf(Mode.WHATSAPP);
    List<String> recipients;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}
