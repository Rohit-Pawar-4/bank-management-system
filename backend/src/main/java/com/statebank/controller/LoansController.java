package com.statebank.controller;
import com.statebank.model.Loan;
import com.statebank.repository.LoanRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoansController {
 private final LoanRepository repository;
 public LoansController(LoanRepository repository){this.repository=repository;}
 @GetMapping public List<Loan> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public Loan one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public Loan create(@Valid @RequestBody Loan body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public Loan update(@PathVariable Long id,@Valid @RequestBody Loan body){return CrudSupport.update(repository,id,body,Loan::getId,Loan::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
