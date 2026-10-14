package com.statebank.controller;
import com.statebank.model.Branch;
import com.statebank.repository.BranchRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchesController {
 private final BranchRepository repository;
 public BranchesController(BranchRepository repository){this.repository=repository;}
 @GetMapping public List<Branch> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public Branch one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public Branch create(@Valid @RequestBody Branch body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public Branch update(@PathVariable Long id,@Valid @RequestBody Branch body){return CrudSupport.update(repository,id,body,Branch::getId,Branch::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
