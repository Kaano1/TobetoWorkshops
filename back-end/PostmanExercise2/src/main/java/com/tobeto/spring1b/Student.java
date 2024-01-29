package com.tobeto.spring1b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class Student {
    @GetMapping
    public String[] getStudent()
    {
        return (new String[]{"pasta", "pasta", "pasta", "pasta"});
    }

    @DeleteMapping
    public String delStudent()
    {
        return ("student not delete but it is happy");
    }

    @PostMapping
    public String postStudent()
    {
        return ("student playing ");
    }
    @PutMapping
    public String putStudent()
    {
        return ("Put is working in putStudent");
    }
}
