package com.spring.test.mockito;


public interface UserRepository {

    User create(User user) ;

    User findById(Long userId);

    User saveOrUpdate(User user);

    User findByContact(Contact contact);


}
