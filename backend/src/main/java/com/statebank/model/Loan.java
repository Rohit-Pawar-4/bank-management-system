package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="loans")
public class Loan {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull private Long customerId; @NotBlank private String loanType;
 @NotNull @DecimalMin("0.01") @Column(precision=15,scale=2) private BigDecimal principalAmount;
 @DecimalMin("0.0") private BigDecimal interestRate; private Integer tenureMonths; private String status="Under Review";
 public Loan(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Long getCustomerId(){return customerId;} public void setCustomerId(Long v){customerId=v;}
 public String getLoanType(){return loanType;} public void setLoanType(String v){loanType=v;}
 public BigDecimal getPrincipalAmount(){return principalAmount;} public void setPrincipalAmount(BigDecimal v){principalAmount=v;}
 public BigDecimal getInterestRate(){return interestRate;} public void setInterestRate(BigDecimal v){interestRate=v;}
 public Integer getTenureMonths(){return tenureMonths;} public void setTenureMonths(Integer v){tenureMonths=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}