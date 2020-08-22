package com.SobreMesa.Campus.Riddles.Services;

import org.springframework.stereotype.Service;
import org.springframework.ws.mime.MimeMessage;

import com.SobreMesa.Campus.Riddles.entity.NotificationEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

public void sendMail(NotificationEmail notificationEmail) {
//        MimeMessage messagePreparator = mimeMessage -> {
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//            messageHelper.setFrom("springreddit@email.com");
//            messageHelper.setTo(notificationEmail.getRecipient());
//            messageHelper.setSubject(notificationEmail.getSubject());
//            messageHelper.setText(notificationEmail.getBody());
//        };
//        try {
//            mailSender.send(messagePreparator);
//            log.info("Activation email sent!!");
//        } catch (MailException e) {
//            
//        }
	}
}
