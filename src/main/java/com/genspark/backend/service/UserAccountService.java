package com.genspark.backend.service;

import com.genspark.backend.entity.UserAccount;
import com.genspark.backend.error.DataNotFoundException;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> getUsers();

    UserAccount getUserById(Long userId) throws DataNotFoundException;

    UserAccount addUser(UserAccount userAccount);

    UserAccount updateUser(UserAccount userAccount, Long userId) throws DataNotFoundException;

    void deleteUser(Long userId) throws DataNotFoundException;

    UserAccount logUser(UserAccount userAccount);

    UserAccount signUp(UserAccount userAccount);
}
