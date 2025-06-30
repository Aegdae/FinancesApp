package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.ExpanseDto;
import com.My.FinancesApp.model.Expanse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.My.FinancesApp.service.ExpanseService;

@RestController
@RequestMapping("/finances")
public class ExpanseController {

    private final ExpanseService expanseService;

    @Autowired
    public ExpanseController(ExpanseService expanseService){
        this.expanseService = expanseService;
    }

    @PostMapping("/expanse")
    public Expanse addExpanse(@RequestBody ExpanseDto expanseDTO){
        return expanseService.createExpanse(expanseDTO);
    }
}
