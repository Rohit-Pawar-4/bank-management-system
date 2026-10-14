package com.statebank.repository;
import com.statebank.model.BankReport;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BankReportRepository extends JpaRepository<BankReport, Long> { }
