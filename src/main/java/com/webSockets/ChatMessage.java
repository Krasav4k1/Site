package com.webSockets;

public class ChatMessage {
  
  private String recipient;
  
  public String getRecipient() { return recipient; }
  public void setRecipient(String recipient) { this.recipient = recipient; }
  
  private String sender;
  
  public String getSender() { return sender; }
  public void setSender(String sender) { this.sender = sender; }
  
  private String message;
  
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }

  private String fotoSender;

  public String getFotoSender() {return fotoSender;}
  public void setFotoSender(String fotoSender) {this.fotoSender = fotoSender;}

  private String firstNameAndLastName;

  public String getFirstNameAndLastName() {return firstNameAndLastName;}
  public void setFirstNameAndLastName(String firstNameAndLastName) {this.firstNameAndLastName = firstNameAndLastName;}

  @Override
  public String toString() {
    return "ChatMessage{" +
            "recipient='" + recipient + '\'' +
            ", sender='" + sender + '\'' +
            ", message='" + message + '\'' +
            ", fotoSender='" + fotoSender + '\'' +
            ", firstNameAndLastName='" + firstNameAndLastName + '\'' +
            '}';
  }
}
