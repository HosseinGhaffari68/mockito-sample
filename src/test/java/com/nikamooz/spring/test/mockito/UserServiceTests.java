package com.nikamooz.spring.test.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

import java.util.Random;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class UserServiceTests {

//    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

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

        return invocationOnMock -> {
            User user = invocationOnMock.getArgument(0);
            user.setId(random.nextLong());
            return user;
        };
    }
}
