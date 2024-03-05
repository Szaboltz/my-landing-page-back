package com.szabo.landingPagebackend.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	MessageRepository messageRepository;
	@Autowired
	public MessageService(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	public void validateMessage(MessageModel messageModel) {
		messageRepository.save(messageModel);
	}
}
