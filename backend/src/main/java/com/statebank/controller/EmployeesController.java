package com.statebank.controller;
import com.statebank.model.Employee;
import com.statebank.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
 private final EmployeeRepository repository;
 public EmployeesController(EmployeeRepository repository){this.repository=repository;}
 @GetMapping public List<Employee> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public Employee one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public Employee create(@Valid @RequestBody Employee body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public Employee update(@PathVariable Long id,@Valid @RequestBody Employee body){return CrudSupport.update(repository,id,body,Employee::getId,Employee::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
