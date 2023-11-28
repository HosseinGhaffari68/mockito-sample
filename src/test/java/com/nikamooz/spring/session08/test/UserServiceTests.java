package com.nikamooz.spring.session08.test;

import com.nikamooz.spring.session08.test.mockito.Contact;
import com.nikamooz.spring.session08.test.mockito.User;
import com.nikamooz.spring.session08.test.mockito.UserRepository;
import com.nikamooz.spring.session08.test.mockito.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Random;


//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class UserServiceTests {

//    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Spy
    ArrayList<String> list = new ArrayList<String>();

    @BeforeEach
    void init() {
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreate(){
        User input = new User("Ali", "Rahmani");
        User output = new User(1L, "Ali", "Rahmani");
        Mockito.when(userRepository.create(Mockito.any())).thenReturn(output);
        Assertions.assertEquals(userRepository.create(input), output);
        Assertions.assertNotNull(output.getId());
    }

    @Test
    public void testUpdateUser(){
        User output = new User(1L, "Ali", "Rahmani");
        Mockito.when(userRepository.findById(1L)).thenReturn(output);
        Mockito.when(userRepository.saveOrUpdate(output)).thenReturn(output);
        Contact contact = new Contact("Tehran", "Yousefabad", "3298239", "389238");
        userService.updateUser(1L, contact);
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findById(Mockito.anyLong());
        Assertions.assertNotNull(output.getContact());
        Assertions.assertEquals(output.getContact(), contact);
    }

    @Test
    public void testSave(){
        User user = new User("Mehdi", "Hoseini");
//        Mockito.when(userRepository.create(user)).thenAnswer(AdditionalAnswers.returnsFirstArg());
        Mockito.when(userRepository.create(user)).thenAnswer(createAnswer());
        userService.save(user);
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
    }

    private Answer<User> createAnswer() {
        Random random = new Random();

        return new Answer<User>(){
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                User user = invocationOnMock.getArgument(0);
                user.setId(random.nextLong());
                return user;
            }
        };
    }

    @Test
    public void testSpy(){
        Mockito.when(list.size()).thenReturn(1);
        list.add("Iran");
        list.add("is");
        list.add("big");
        list.add("country");
        Assertions.assertEquals(1, list.size());
    }
}
