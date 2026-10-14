package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="accounts")
public class BankAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long customerId;
 @Column(unique=true) private String accountNumber;
 @NotBlank private String accountType;
 @DecimalMin("0.0") @Column(precision=15,scale=2) private BigDecimal balance=BigDecimal.ZERO;
 private Long branchId; private String status="Active"; private LocalDate openedDate=LocalDate.now();
 public BankAccount(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getCustomerId(){return customerId;} public void setCustomerId(Long v){customerId=v;}
 public String getAccountNumber(){return accountNumber;} public void setAccountNumber(String v){accountNumber=v;}
 public String getAccountType(){return accountType;} public void setAccountType(String v){accountType=v;}
 public BigDecimal getBalance(){return balance;} public void setBalance(BigDecimal v){balance=v;}
 public Long getBranchId(){return branchId;} public void setBranchId(Long v){branchId=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public LocalDate getOpenedDate(){return openedDate;} public void setOpenedDate(LocalDate v){openedDate=v;}
}