package com.statebank.controller;
import com.statebank.model.BankAccount;
import com.statebank.repository.BankAccountRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {
 private final BankAccountRepository repository;
 public AccountsController(BankAccountRepository repository){this.repository=repository;}
 @GetMapping public List<BankAccount> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public BankAccount one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public BankAccount create(@Valid @RequestBody BankAccount body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public BankAccount update(@PathVariable Long id,@Valid @RequestBody BankAccount body){return CrudSupport.update(repository,id,body,BankAccount::getId,BankAccount::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
