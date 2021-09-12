package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;

@Service
public class SendMailServices{
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Users user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getUserName());
		mailMessage.setSubject("Bienvenid@ a apiDisney");
		mailMessage.setText("Su cuenta fue creada con exito. Inicie sesion y podra acceder a todas las funcionalidades de la api");
		mailSender.send(mailMessage);
	}
}
