package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.ExpanseDto;
import com.My.FinancesApp.model.Expanse;
import com.My.FinancesApp.model.User;
import com.My.FinancesApp.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.My.FinancesApp.repository.ExpanseRepository;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class ExpanseService {

    private final ExpanseRepository expanseRepository;

    public ExpanseService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public Expanse createExpanse(ExpanseDto expanseDTO){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String userId = userDetails.getId();

        Expanse expanse = new Expanse();
        expanse.setName(expanseDTO.getName());
        expanse.setDescription(expanseDTO.getDescription());
        expanse.setValue(expanseDTO.getValue());
        expanse.setDate(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant());
        expanse.setCategory(expanseDTO.getCategory());

        User user = new User();
        user.setId(userId);
        expanse.setUser(user);

        return expanseRepository.save(expanse);
    }

}
