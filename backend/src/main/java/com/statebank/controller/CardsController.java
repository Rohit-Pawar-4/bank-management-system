package com.statebank.controller;
import com.statebank.model.BankCard;
import com.statebank.repository.BankCardRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {
 private final BankCardRepository repository;
 public CardsController(BankCardRepository repository){this.repository=repository;}
 @GetMapping public List<BankCard> all(){return CrudSupport.all(repository);}
 @GetMapping("/{id}") public BankCard one(@PathVariable Long id){return CrudSupport.one(repository,id);}
 @PostMapping public BankCard create(@Valid @RequestBody BankCard body){body.setId(null);return CrudSupport.create(repository,body);}
 @PutMapping("/{id}") public BankCard update(@PathVariable Long id,@Valid @RequestBody BankCard body){return CrudSupport.update(repository,id,body,BankCard::getId,BankCard::setId);}
 @DeleteMapping("/{id}") @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){CrudSupport.delete(repository,id);}
}
