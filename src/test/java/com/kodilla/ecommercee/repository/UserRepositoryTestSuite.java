package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Key;
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
import java.util.List;
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
        Set<Key> user1Set = new HashSet<>();
        user1Set.add(new Key(
                123456789L,
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00, 00),
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 59,59)));
        user1Set.add(new Key(
                987654321L,
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 00, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 59,59)));

        Set<Key> user2Set = new HashSet<>();
        user2Set.add(new Key(
                3456789L,
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 00, 00),
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 59,59)));
        user2Set.add(new Key(
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
        List<User> users = userRepository.findAll();
        Long user1Id = user1.getId();
        Long user2Id = user2.getId();
        Optional<User> user1FromDB = userRepository.findById(user1Id);
        Optional<User> user2FromDB = userRepository.findById(user2Id);

        //Then
        Assert.assertEquals(2, users.size());
        Assert.assertEquals(user1Id, user1FromDB.get().getId());
        Assert.assertEquals(user2Id, user2FromDB.get().getId());
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
        List<User> users = userRepository.findAll();
        Optional<User> user2FromDB = userRepository.findById(user2Id);

        //Then
        Assert.assertEquals(1, users.size());
        Assert.assertTrue(user2FromDB.isPresent());
    }
}



