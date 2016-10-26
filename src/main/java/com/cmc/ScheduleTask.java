package com.cmc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
    private transient JavaMailSender mailTemplate;

    @Autowired
    private transient SimpleMailMessage templateMessage;

    public void sendMessage(String mailTo, String message) {
        org.springframework.mail.SimpleMailMessage mailMessage = new org.springframework.mail.SimpleMailMessage(templateMessage);
        mailMessage.setTo(mailTo);
        mailMessage.setText(message);
        try{
        mailTemplate.send(mailMessage);
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	
	

	@Scheduled(fixedRate = 5000)
	public void helloWorldTask() {
		System.out.println("Fxied rate every 5 second " + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "*/30 * * * * *")
	public void runEvery10Sec() {
		System.out.println("Cron expression - Run every 30 second - " + dateFormat.format(new Date()));
		sendMessage("phuongnm.mail@gmail.com","hello ! im new QMS");
	}
	
}