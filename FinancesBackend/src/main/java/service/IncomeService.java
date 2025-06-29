package service;

import model.Income;
import org.springframework.stereotype.Service;
import repository.IncomeRepository;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }
}
