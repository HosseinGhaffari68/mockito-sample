package com.nikamooz.spring.session08.test.mockito;

import java.util.logging.Logger;


public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Logger logger = Logger.getLogger(UserService.class.getName());

    public User updateUser(Long userId, Contact contact){
        User user = userRepository.findById(userId);
        user.setContact(contact);
        userRepository.saveOrUpdate(user);
        return user;
    }

    public User save(User user){
        return userRepository.create(user);
    }
}
