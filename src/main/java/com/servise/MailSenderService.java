package com.servise;

public interface MailSenderService {

    void sendMail(String content, String email, String path);

}
