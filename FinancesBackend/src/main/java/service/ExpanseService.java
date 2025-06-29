package service;

import model.Expanse;
import org.springframework.stereotype.Service;
import repository.ExpanseRepository;

@Service
public class ExpanseService {

    private final ExpanseRepository expanseRepository;

    public ExpanseService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public Expanse createExpanse(Expanse expanse){
        return expanseRepository.save(expanse);
    }

}
