package com.szabo.landingpagebackend.messages;

import lombok.Data;

@Data
public class Messages {
  private String message;
  private Boolean success;

  public Messages (Boolean success, String message) {
    this.message = message;
    this.success = success;
  }

}
