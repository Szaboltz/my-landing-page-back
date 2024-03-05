package com.szabo.landingPagebackend.message;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class MessageController {
	private final MessageService messageService;

	public MessageController(MessageService messageService){
		this.messageService = messageService;
	}

	// @GetMapping
	// public void getMessage(){}

	@PostMapping("create")
	public void create(@RequestBody MessageModel messageModel){
		messageService.validateMessage(messageModel);
	}
}
