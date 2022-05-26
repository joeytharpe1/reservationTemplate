package com.genspark.backend.service;

import com.genspark.backend.entity.UserAccount;
import com.genspark.backend.error.DataNotFoundException;
import com.genspark.backend.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserAccountServiceImp implements UserAccountService{

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Override
    public List<UserAccount> getUsers() {
        return this.userAccountRepo.findAll();
    }

    @Override
    public UserAccount getUserById(Long userId) throws DataNotFoundException {
        Optional<UserAccount> userAccountOptional = userAccountRepo.findById(userId);
        if(!userAccountOptional.isPresent())
            throw new DataNotFoundException("user with id: " + userId + " not found");
        return userAccountOptional.get();
    }

    @Override
    public UserAccount addUser(UserAccount userAccount) {
        return userAccountRepo.save(userAccount);
    }

    @Override
    public UserAccount updateUser(UserAccount userAccount, Long userId) throws DataNotFoundException {
        Optional<UserAccount> updateUserOptional = userAccountRepo.findById(userId);
        if(!updateUserOptional.isPresent())
            throw new DataNotFoundException("user with id: " + userId + " not found");

        UserAccount userAccountUpdated = updateUserOptional.get();

        if(userAccount.getEmail() != null)
            userAccountUpdated.setEmail(userAccount.getEmail());
        if(userAccount.getPassword() != null)
            userAccountUpdated.setPassword(userAccount.getPassword());
        if(userAccount.getUserNumber() != null)
            userAccountUpdated.setUserNumber(userAccount.getUserNumber());
        if(userAccount.getUserName() != null)
            userAccountUpdated.setUserName(userAccount.getUserName());

        return userAccountRepo.save(userAccountUpdated);
    }

    @Override
    public void deleteUser(Long userId) throws DataNotFoundException {
        Optional<UserAccount> userAccountOptional = userAccountRepo.findById(userId);
        if(!userAccountOptional.isPresent())
            throw new DataNotFoundException("user not found");
        userAccountRepo.deleteById(userId);
    }

    @Override
    public UserAccount logUser(UserAccount userAccount) {
        return userAccountRepo.save(userAccount);
    }

    @Override
    public UserAccount signUp(UserAccount userAccount) {
        return userAccountRepo.save(userAccount);
    }
}
