package com.onlineshop.usermanagement.service.user;

import com.digi.microserviceusermanagement.model.entity.User;
import com.digi.microserviceusermanagement.repository.user.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepo.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
