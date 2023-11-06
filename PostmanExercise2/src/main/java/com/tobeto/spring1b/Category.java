package com.tobeto.spring1b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Category {


    @GetMapping
    public String[] getCategory()
    {
        return (new String[]{"dring", "food", "needed", "dresses"});
    }

    @DeleteMapping
    public String delCategory()
    {
        return ("category not delete but it is happy");
    }

    @PostMapping
    public String postCategory()
    {
        return ("Post category");
    }
    @PutMapping
    public String putCategory()
    {
        return ("Put is working in putCategory");
    }
}
