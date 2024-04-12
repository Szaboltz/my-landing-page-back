package com.szabo.landingpagebackend.messages;

import lombok.Data;

@Data
public class Messages {
  private String message;
  private boolean success;

  public Messages (boolean success, String message) {
    this.message = message;
    this.success = success;
  }

}
