package com.statebank.repository;
import com.statebank.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BankCardRepository extends JpaRepository<BankCard, Long> { }
