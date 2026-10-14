package com.statebank.controller;
import com.statebank.model.Customer;
import com.statebank.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
 private final CustomerRepository repository;
 public CustomersController(CustomerRepository repository){this.repository=repository;}
 @GetMapping public List<Customer> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public Customer one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public Customer create(@Valid @RequestBody Customer body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public Customer update(@PathVariable Long id,@Valid @RequestBody Customer body){return CrudSupport.update(repository,id,body,Customer::getId,Customer::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
