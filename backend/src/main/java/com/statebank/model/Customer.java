package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="customers")
public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String name;
 @Email @Column(unique=true) private String email;
 @Pattern(regexp="^[0-9+() -]{7,20}$") private String phone;
 private String accountType;
 @DecimalMin("0.0") @Column(precision=15,scale=2) private BigDecimal balance=BigDecimal.ZERO;
 @Column(length=500) private String address;
 private String kycStatus="Pending";
 private String status="Active";
 public Customer() {}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getAccountType(){return accountType;} public void setAccountType(String v){accountType=v;}
 public BigDecimal getBalance(){return balance;} public void setBalance(BigDecimal v){balance=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
 public String getKycStatus(){return kycStatus;} public void setKycStatus(String v){kycStatus=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}