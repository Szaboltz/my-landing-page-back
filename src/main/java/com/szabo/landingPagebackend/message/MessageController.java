package com.szabo.landingPagebackend.message;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/")
public class MessageController {
	private final MessageService messageService;
	@Autowired
	public MessageController(MessageService messageService){
		this.messageService = messageService;
	}

	@GetMapping
	public void getMessage(){}
	@PostMapping("create")
	public void create(@RequestBody MessageModel messageModel){
		messageService.validateMessage(messageModel);
	}
}
