package com.szabo.landingpagebackend.controllers;

import com.szabo.landingpagebackend.modals.MessageModel;
import com.szabo.landingpagebackend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szabo.landingpagebackend.services.EmailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private EmailService emailService;

	private String convertObjectToString(MessageModel messageModel) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(messageModel);
		} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}

	@PostMapping("/send")
	public void create(@RequestBody MessageModel messageModel) {
		String json = convertObjectToString(messageModel);
		emailService.sendEmail("Sou eu!", json);
		messageService.validateMessage(messageModel);
	}
}
