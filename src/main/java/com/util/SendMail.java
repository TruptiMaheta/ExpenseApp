package com.util;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//mail.jar//action.jar

import com.bean.UserBean;

public class SendMail{
	static String to;
	public static String otp;

	
	public static void sendMail() {
		
		String usermessage="";
		String to="160120107058@git.org.in";
		String from = "truptimaheta227@gmail.com";
		final String username = "truptimaheta227@gmail.com";// change accordingly
		final String password = "227t@810";// change accordingly

		Properties props = new Properties();
		props.put("mail.smtp.user", "username");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		// Get the Session object.
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			int r=(int)(Math.random()*900000)+100000;
			otp=String.valueOf(r);
			// Set Subject: header field
			message.setSubject("Forget Password");

			// Now set the actual message
			message.setText(otp);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		
		/*
		 * SendMail s=new SendMail(); s.sendMail();
		 */
		//String code=s.getRandom();
		//System.out.println(code);
		
	}
	

}