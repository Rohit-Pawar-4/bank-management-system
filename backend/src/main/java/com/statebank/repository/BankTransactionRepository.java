package com.statebank.repository;
import com.statebank.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> { }
