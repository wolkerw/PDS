package com.funcoes;


import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
public class Email {
 
	public void enviaEmail(String destinatario, String anexo, String assunto, String mensagem) {
 
		Connection conn = null;
		
		final String username = "unisc@dl.inf.br";
		final String password = "qwe134679";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			
		  // cria a mensagem
		  MimeMessage msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress("unisc@dl.inf.br"));
		  InternetAddress[] address = {new InternetAddress(destinatario)};
		  msg.setRecipients(Message.RecipientType.TO, address);
		  msg.setSubject(assunto);
		
		  // cria a primeira parte da mensagem
		  MimeBodyPart mbp1 = new MimeBodyPart();
		  mbp1.setText("\n"+mensagem+"\n\n"+
		               "Este e-mail foi gerado automaticamente pelo sistema! Favor não responder para este endereço pois seu e-mail não será lido!");
		
		  // cria a segunda parte da mensage
		  //MimeBodyPart mbp2 = new MimeBodyPart();
		
		  // anexa o arquivo na mensagem
		  //FileDataSource fds = new FileDataSource(anexo);
		  //mbp2.setDataHandler(new DataHandler(fds));
		  //mbp2.setFileName(fds.getName());
		
		  // cria a Multipart
		  Multipart mp = new MimeMultipart();
		  mp.addBodyPart(mbp1);
		  //mp.addBodyPart(mbp2);
		
		  // adiciona a Multipart na mensagem
		  msg.setContent(mp);
		
		  // configura a data: cabecalho
		  msg.setSentDate(new Date());

 
			Transport.send(msg);
 
			System.out.println("Email Enviado com sucesso!");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
