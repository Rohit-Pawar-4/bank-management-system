package com.statebank.config;

import com.statebank.model.*;
import com.statebank.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class SeedData {
 @Bean CommandLineRunner seed(CustomerRepository customers, BankAccountRepository accounts,
   BankTransactionRepository transactions, BankCardRepository cards, LoanRepository loans,
   BranchRepository branches, EmployeeRepository employees, BankReportRepository reports) {
  return args -> {
   if(branches.count()==0){
    Branch b1=new Branch(); b1.setName("Pune Main Branch"); b1.setManagerName("Anita Rao"); b1.setCity("Pune"); b1.setAddress("Shivajinagar, Pune"); b1.setPhone("02025501234"); b1.setStatus("Operational"); branches.save(b1);
    Branch b2=new Branch(); b2.setName("Mumbai Central"); b2.setManagerName("Vikram Shah"); b2.setCity("Mumbai"); b2.setAddress("Fort, Mumbai"); b2.setPhone("02222001234"); b2.setStatus("Operational"); branches.save(b2);
   }
   if(customers.count()==0){
    Customer c1=new Customer(); c1.setName("Aarav Sharma"); c1.setEmail("aarav.sharma@example.com"); c1.setPhone("9876543210"); c1.setAccountType("Savings"); c1.setBalance(new BigDecimal("248500")); c1.setAddress("Pune, Maharashtra"); c1.setKycStatus("Verified"); c1.setStatus("Active"); customers.save(c1);
    Customer c2=new Customer(); c2.setName("Priya Mehta"); c2.setEmail("priya.mehta@example.com"); c2.setPhone("9876543211"); c2.setAccountType("Current"); c2.setBalance(new BigDecimal("876240")); c2.setAddress("Mumbai, Maharashtra"); c2.setKycStatus("Verified"); c2.setStatus("Active"); customers.save(c2);
    Customer c3=new Customer(); c3.setName("Sneha Patil"); c3.setEmail("sneha.patil@example.com"); c3.setPhone("9876543213"); c3.setAccountType("Salary"); c3.setBalance(new BigDecimal("134090")); c3.setAddress("Nashik, Maharashtra"); c3.setKycStatus("Pending"); c3.setStatus("Pending KYC"); customers.save(c3);
   }
   if(accounts.count()==0){
    BankAccount a1=new BankAccount(); a1.setCustomerId(1L); a1.setAccountNumber("SB10003021"); a1.setAccountType("Savings"); a1.setBalance(new BigDecimal("248500")); a1.setBranchId(1L); a1.setStatus("Active"); a1.setOpenedDate(LocalDate.now().minusYears(2)); accounts.save(a1);
    BankAccount a2=new BankAccount(); a2.setCustomerId(2L); a2.setAccountNumber("CA10008846"); a2.setAccountType("Current"); a2.setBalance(new BigDecimal("876240")); a2.setBranchId(2L); a2.setStatus("Active"); a2.setOpenedDate(LocalDate.now().minusYears(1)); accounts.save(a2);
   }
   if(transactions.count()==0){
    BankTransaction t=new BankTransaction(); t.setAccountId(1L); t.setTransactionType("Deposit"); t.setAmount(new BigDecimal("24500")); t.setDescription("Demo incoming transfer"); t.setTransactionDate(LocalDate.now()); t.setStatus("Completed"); transactions.save(t);
   }
   if(cards.count()==0){
    BankCard c=new BankCard(); c.setCustomerId(1L); c.setAccountId(1L); c.setCardType("Debit"); c.setMaskedNumber("•••• •••• •••• 3021"); c.setExpiryDate(LocalDate.now().plusYears(2)); c.setStatus("Active"); cards.save(c);
   }
   if(loans.count()==0){
    Loan l=new Loan(); l.setCustomerId(2L); l.setLoanType("Home Loan"); l.setPrincipalAmount(new BigDecimal("2500000")); l.setInterestRate(new BigDecimal("8.5")); l.setTenureMonths(240); l.setStatus("Active"); loans.save(l);
   }
   if(employees.count()==0){
    Employee e=new Employee(); e.setName("Anita Rao"); e.setEmail("anita.rao@example.com"); e.setPhone("9876500001"); e.setRole("Branch Manager"); e.setBranchId(1L); e.setDepartment("Operations"); e.setStatus("Active"); employees.save(e);
   }
   if(reports.count()==0){
    BankReport r=new BankReport(); r.setName("Daily transaction summary"); r.setCategory("Transactions"); r.setGeneratedDate(LocalDate.now()); r.setOwner("Rahul Kumar"); r.setStatus("Ready"); reports.save(r);
   }
  };
 }
}