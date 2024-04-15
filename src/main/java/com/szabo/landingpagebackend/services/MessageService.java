package com.szabo.landingpagebackend.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szabo.landingpagebackend.modals.MessageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
	@Autowired
	private ObjectMapper objectMapper;

  public String convertObjectToString(MessageModel messageModel) {
    try {
      return objectMapper.writeValueAsString(messageModel);
    } catch (JsonProcessingException e) {
      return null;
    }
  }

	public String formatMessage(MessageModel messageModel) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		messageModel.setDateTime(currentDateTime);
		return convertObjectToString(messageModel);
	}
}

