package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.UpdateUserDto;
import com.My.FinancesApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.My.FinancesApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findByEmail(updateUserDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        User updateUser = User.builder()
                .id(user.getId())
                .name(updateUserDto.getName() != null ? updateUserDto.getName() : user.getName())
                .email(updateUserDto.getEmail() != null ? updateUserDto.getEmail() : user.getEmail())
                .password(updateUserDto.getPassword() != null ? updateUserDto.getPassword() : user.getPassword())
                .bornDate(updateUserDto.getBornDate() != null ? updateUserDto.getBornDate() : user.getBornDate())
                .build();

        userRepository.save(updateUser);
    }

    public void deleteUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            userRepository.deleteById(user.get().getId());
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
