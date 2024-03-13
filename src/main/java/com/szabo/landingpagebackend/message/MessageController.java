package com.szabo.landingpagebackend.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szabo.landingpagebackend.email.EmailService;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private EmailService emailService;

	private String convertObjectToString(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}

	@PostMapping("create")
	public void create(@RequestBody MessageModel messageModel) throws MessagingException{
		String json = convertObjectToString(messageModel);
		emailService.sendEmail("Menssagem recebida", json);
		messageService.validateMessage(messageModel);
	}
}