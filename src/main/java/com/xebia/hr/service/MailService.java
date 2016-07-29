package com.xebia.hr.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MailService {
	
	private Logger logger = Logger.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String[] to, String[] cc, String[] bcc, String subject, String body, String attachment) throws MessagingException{
		
		logger.info("Executing sendMail() method...");
		MimeMessage message = mailSender.createMimeMessage();

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		if(ArrayUtils.isEmpty(to)){
			Assert.notNull(to, "To address must not be null");
		}
		helper.setTo(to);
		
		if(ArrayUtils.isNotEmpty(cc)){
			helper.setCc(cc);
		}
		if(ArrayUtils.isNotEmpty(bcc)){
			helper.setBcc(bcc);
		}
		if(StringUtils.isNotEmpty(attachment)){
			/*FileSystemResource file = new FileSystemResource(new File(attachment));
			helper.addAttachment(FilenameUtils.getName(attachment), file);*/
		}
		
		helper.setSubject(subject);
		helper.setText(body);

		mailSender.send(message);
		logger.info("Mail sent successfully.");
	}

}
