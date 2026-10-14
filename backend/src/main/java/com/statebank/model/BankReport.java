package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity @Table(name="reports")
public class BankReport {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; private String category; private LocalDate generatedDate=LocalDate.now(); private String owner; private String status="Ready";
 public BankReport(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public LocalDate getGeneratedDate(){return generatedDate;} public void setGeneratedDate(LocalDate v){generatedDate=v;}
 public String getOwner(){return owner;} public void setOwner(String v){owner=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}