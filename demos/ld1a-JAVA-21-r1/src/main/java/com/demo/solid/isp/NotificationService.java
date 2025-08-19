package com.demo.solid.isp;

class NotificationService {
    private final EmailNotifier email;
    private final SMSNotifier sms;

    public NotificationService(EmailNotifier email, SMSNotifier sms) {
        this.email = email;
        this.sms = sms;
    }

    public void notifyCustomer(String emailAddr, String phone, String msg) {
        email.sendEmail(emailAddr, msg);
        sms.sendSMS(phone, msg);
    }
}