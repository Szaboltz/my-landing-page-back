package com.szabo.landingpagebackend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szabo.landingpagebackend.modals.MessageModel;
import com.szabo.landingpagebackend.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageService {
	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}

	public String convertObjectToString(MessageModel messageModel) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(messageModel);
		} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}

	private String dateToString(LocalDateTime data){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return data.format(formatter);
	}

	public void validateMessage(MessageModel messageModel) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		messageModel.setDateTime(dateToString(currentDateTime));
		messageRepository.save(messageModel);
	}
}

