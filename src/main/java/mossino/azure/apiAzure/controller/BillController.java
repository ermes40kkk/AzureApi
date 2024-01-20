package mossino.azure.apiAzure.controller;


import mossino.azure.apiAzure.model.Bill;
import mossino.azure.apiAzure.repository.BillCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bills")
@CrossOrigin("*")
public class BillController {
    private final BillCollectionRepository repository;
@Autowired
    public BillController(BillCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Bill> findAll(){
         return repository.finAll();
    }

    @GetMapping("/{id}")
    public Optional<Bill> findById(@PathVariable Integer id){
        return Optional.ofNullable(repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found")));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Bill bill){
        repository.save(bill);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Bill bill){
    if(!repository.existsById(id)){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found");
    }
        Bill billToUpdate = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Content not found"));
        billToUpdate = bill;
        repository.save(billToUpdate);
   }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.deleteById(id);
    }
}
