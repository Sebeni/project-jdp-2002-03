package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Token;
import com.kodilla.ecommercee.domain.User;
import org.junit.After;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
                "860c5c50-274f-4cb9-9735-c7cc58b9d701",
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 00, 00),
                LocalDateTime.of(2020, Month.JANUARY, 1, 12, 59,59)));
        user1Set.add(new Token(
                "d7660de1-da71-48a4-81db-494a002b5b5e",
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 00, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 2, 13, 59,59)));

        Set<Token> user2Set = new HashSet<>();
        user2Set.add(new Token(
                "6579cf0a-8a51-4b4e-bda6-f4b9764c2d01",
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 00, 00),
                LocalDateTime.of(2020, Month.MARCH, 3, 14, 59,59)));
        user2Set.add(new Token(
                "d33c697d-677d-4178-8e86-60880edabd05",
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
                "5b08be16-2cb6-46d5-bf98-7d7d750df0ca",
                LocalDateTime.of(2020, Month.MAY, 5, 15, 00, 00),
                LocalDateTime.of(2020, Month.MAY, 5, 15, 59,59)));
        user3Set.add(new Token(
                "61614667-d279-11e7-a5ac-f941ac8dfc39",
                LocalDateTime.of(2020, Month.JUNE, 6, 16, 00, 00),
                LocalDateTime.of(2020, Month.JUNE, 6, 16, 59,59)));

        User user3 = new User("Cesia", user3Set, false);

        int usersListBefore = userRepository.findAll().size();
        userRepository.save(user3);
        int usersListAfter = userRepository.findAll().size();

        //Then
        assertEquals(1, usersListAfter - usersListBefore);
    }

    @Test
    public void testUserRepositoryFindById() {
        //When
        Long user1Id = user1.getId();
        Optional<User> user1FromDB = userRepository.findById(user1Id);
        Long user2Id = user2.getId();
        Optional<User> user2FromDB = userRepository.findById(user2Id);

        //Then
        assertEquals(user1Id, user1FromDB.get().getId());
        assertEquals(user2Id, user2FromDB.get().getId());
    }

    @Test
    public void testUserRepositoryDeleteById() {
        //When
        Long user1Id = user1.getId();
        Long user2Id = user2.getId();
        userRepository.deleteById(user1Id);

        //Then
        assertEquals(1, userRepository.count());
        assertTrue(userRepository.existsById(user2Id));
    }
}



