package com.szabo.landingpagebackend.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class MessageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "The name must be insert")
	private String name;

	@Email(message = "The email must be valid!")
	@NotBlank(message = "The email must be insert")
	private String email;

	@Size(min = 3)
	@NotBlank(message = "The message must be insert")
	private String message;

	private String dateTime;

}
