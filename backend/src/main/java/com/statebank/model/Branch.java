package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="branches")
public class Branch {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; private String managerName; private String city;
 @Column(length=500) private String address; private String phone; private String status="Operational";
 public Branch(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getManagerName(){return managerName;} public void setManagerName(String v){managerName=v;}
 public String getCity(){return city;} public void setCity(String v){city=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}