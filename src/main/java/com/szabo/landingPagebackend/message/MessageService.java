package com.szabo.landingPagebackend.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageService {
	private final MessageRepository messageRepository;
	@Autowired
	public MessageService(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}

	private String dateToString(LocalDateTime data){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = data.format(formatter);
		return  formattedDateTime;
	}

	public void validateMessage(MessageModel messageModel) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		messageModel.setDateTime(dateToString(currentDateTime));
		messageRepository.save(messageModel);
	}
}
