package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.ExpanseDto;
import com.My.FinancesApp.model.Expanse;
import org.springframework.stereotype.Service;
import com.My.FinancesApp.repository.ExpanseRepository;

@Service
public class ExpanseService {

    private final ExpanseRepository expanseRepository;

    public ExpanseService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public Expanse createExpanse(ExpanseDto expanseDTO){
        Expanse expanse = new Expanse();
        expanse.setName(expanseDTO.getName());
        expanse.setDescription(expanseDTO.getDescription());
        expanse.setValue(expanseDTO.getValue());
        expanse.setCategory(expanseDTO.getCategory());

        return expanseRepository.save(expanse);
    }

}
