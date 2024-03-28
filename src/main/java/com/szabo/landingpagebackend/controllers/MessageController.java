package com.szabo.landingpagebackend.controllers;

import com.szabo.landingpagebackend.modals.MessageModel;
import com.szabo.landingpagebackend.services.MessageService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.szabo.landingpagebackend.services.EmailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<?> create(@Valid @RequestBody MessageModel messageModel) {
		messageService.validateMessage(messageModel);
		String json = messageService.convertObjectToString(messageModel);
		emailService.sendEmail("Sou eu!", json);

		return ResponseEntity.ok(200);
	}
}
