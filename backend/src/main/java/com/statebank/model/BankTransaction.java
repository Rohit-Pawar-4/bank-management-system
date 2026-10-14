package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="transactions")
public class BankTransaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long accountId; @NotBlank private String transactionType;
 @NotNull @DecimalMin("0.01") @Column(precision=15,scale=2) private BigDecimal amount;
 @Column(length=500) private String description; private LocalDate transactionDate=LocalDate.now(); private String status="Pending";
 public BankTransaction(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getAccountId(){return accountId;} public void setAccountId(Long v){accountId=v;}
 public String getTransactionType(){return transactionType;} public void setTransactionType(String v){transactionType=v;}
 public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public LocalDate getTransactionDate(){return transactionDate;} public void setTransactionDate(LocalDate v){transactionDate=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}