package com.statebank.controller;
import com.statebank.model.BankReport;
import com.statebank.repository.BankReportRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
 private final BankReportRepository repository;
 public ReportsController(BankReportRepository repository){this.repository=repository;}
 @GetMapping public List<BankReport> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public BankReport one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public BankReport create(@Valid @RequestBody BankReport body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public BankReport update(@PathVariable Long id,@Valid @RequestBody BankReport body){return CrudSupport.update(repository,id,body,BankReport::getId,BankReport::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
