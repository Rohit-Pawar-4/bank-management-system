package com.statebank.controller;
import com.statebank.model.BankTransaction;
import com.statebank.repository.BankTransactionRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {
 private final BankTransactionRepository repository;
 public TransactionsController(BankTransactionRepository repository){this.repository=repository;}
 @GetMapping public List<BankTransaction> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public BankTransaction one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public BankTransaction create(@Valid @RequestBody BankTransaction body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public BankTransaction update(@PathVariable Long id,@Valid @RequestBody BankTransaction body){return CrudSupport.update(repository,id,body,BankTransaction::getId,BankTransaction::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
