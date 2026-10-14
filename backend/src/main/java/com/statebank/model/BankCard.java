package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity @Table(name="cards")
public class BankCard {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long customerId; private Long accountId; @NotBlank private String cardType;
 @NotBlank private String maskedNumber; private LocalDate expiryDate; private String status="Active";
 public BankCard(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getCustomerId(){return customerId;} public void setCustomerId(Long v){customerId=v;}
 public Long getAccountId(){return accountId;} public void setAccountId(Long v){accountId=v;}
 public String getCardType(){return cardType;} public void setCardType(String v){cardType=v;}
 public String getMaskedNumber(){return maskedNumber;} public void setMaskedNumber(String v){maskedNumber=v;}
 public LocalDate getExpiryDate(){return expiryDate;} public void setExpiryDate(LocalDate v){expiryDate=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}