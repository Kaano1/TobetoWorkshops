package com.tobeto.spring1b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {
    List<Person> inMemoryList = new ArrayList<>();

    @GetMapping
    public List<Person> get(){
        return inMemoryList;
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable int id){
        Person person = inMemoryList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == id) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        return person;
    }

    @PostMapping
    public void add(@RequestBody Person person)
    {
        inMemoryList.add(person);
    }
    @PutMapping
    public void update(@RequestBody Person person)
    {
        for (int i = 0; i <inMemoryList.size(); i++){
            Person per =inMemoryList.get(i);
            if (per.getId() == person.getId()){
                inMemoryList.set(i, person);
                break;
            }
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        boolean result = inMemoryList.removeIf((p)-> p.getId() == id);

        if (!result) {
            throw new IllegalArgumentException("Böyle biri bulunamadı" + id);
        }
    }

}
