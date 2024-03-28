package com.szabo.landingpagebackend.controllers;

import com.szabo.landingpagebackend.messages.Messages;
import com.szabo.landingpagebackend.modals.MessageModel;
import com.szabo.landingpagebackend.services.MessageService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
		emailService.sendEmail("New Message!", messageService.formatMessage(messageModel));

		Messages messages = new Messages(true, "Menssagem enviada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(messages);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex
				.getBindingResult()
				.getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
