package com.statebank.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="employees")
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @Email private String email; private String phone;
 @NotBlank private String role; private Long branchId; private String department; private String status="Active";
 public Employee(){}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
 public Long getBranchId(){return branchId;} public void setBranchId(Long v){branchId=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}