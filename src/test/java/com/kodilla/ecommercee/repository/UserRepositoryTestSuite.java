package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Token;
import com.kodilla.ecommercee.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;

    @Before
    public void init() {
        //Given
        Set<Token> user1Set = new HashSet<>();
        user1Set.add(new Token(
                123456789L,
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00, 00),
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 59,59)));
        user1Set.add(new Token(
                987654321L,
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 00, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 59,59)));

        Set<Token> user2Set = new HashSet<>();
        user2Set.add(new Token(
                3456789L,
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 00, 00),
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 59,59)));
        user2Set.add(new Token(
                9876543L,
                LocalDateTime.of(2020, Month.APRIL, 4, 15, 00, 00),
                LocalDateTime.of(2020, Month.APRIL, 4, 15, 59,59)));

        user1 = new User("Ania", user1Set, false);
        user2 = new User("Basia", user2Set, false);

        userRepository.save(user1);
        userRepository.save(user2);
    }

    @After
    public void delete() {
        userRepository.deleteAll();
    }

    @Test
    public void testUserRepositoryFindAll() {
        //When
        Set<Token> user3Set = new HashSet<>();
        user3Set.add(new Token(
                11111111L,
                LocalDateTime.of(2020, Month.MAY, 5, 15, 00, 00),
                LocalDateTime.of(2020, Month.MAY, 5, 15, 59,59)));
        user3Set.add(new Token(
                2222222L,
                LocalDateTime.of(2020, Month.JUNE, 6, 16, 00, 00),
                LocalDateTime.of(2020, Month.JUNE, 6, 16, 59,59)));

        User user3 = new User("Cesia", user3Set, false);

        int usersListBefore = userRepository.findAll().size();
        userRepository.save(user3);
        int usersListAfter = userRepository.findAll().size();

        //Then
        Assert.assertEquals(1, usersListAfter - usersListBefore);
    }

    @Test
    public void testUserRepositoryFindById() {
        //When
        Long user1Id = user1.getId();
        Optional<User> user1FromDB = userRepository.findById(user1Id);
        Long user2Id = user2.getId();
        Optional<User> user2FromDB = userRepository.findById(user2Id);

        //Then
        Assert.assertEquals(user1Id, user1FromDB.get().getId());
        Assert.assertEquals(user2Id, user2FromDB.get().getId());
    }

    @Test
    public void testUserRepositoryDeleteById() {
        //When
        Long user1Id = user1.getId();
        Long user2Id = user2.getId();
        userRepository.deleteById(user1Id);

        //Then
        Assert.assertEquals(1, userRepository.count());
        Assert.assertTrue(userRepository.existsById(user2Id));
    }
}



