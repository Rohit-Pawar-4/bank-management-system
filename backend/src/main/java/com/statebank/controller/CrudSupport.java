package com.statebank.controller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CrudSupport {
 public static <T> List<T> all(JpaRepository<T,Long> repo){return repo.findAll();}
 public static <T> T one(JpaRepository<T,Long> repo, Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Record not found: "+id));}
 public static <T> T create(JpaRepository<T,Long> repo,T body){return repo.save(body);}
 public static <T> T update(JpaRepository<T,Long> repo,Long id,T body,Function<T,Long> getId,BiConsumer<T,Long> setId){
   if(!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record not found: "+id);
   setId.accept(body,id); return repo.save(body);
 }
 public static <T> void delete(JpaRepository<T,Long> repo,Long id){
   if(!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record not found: "+id);
   repo.deleteById(id);
 }
}