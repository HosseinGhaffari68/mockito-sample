package com.nikamooz.spring.session08.test.mockito;

import java.util.logging.Logger;


public interface UserRepository {

    User create(User user) ;

    User findById(Long userId);

    User saveOrUpdate(User user);

    User findByContact(Contact contact);


}
