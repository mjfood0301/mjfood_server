package mj.mjfood.service;

import mj.mjfood.entity.User;
import mj.mjfood.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        //given
        User user = new User();
        user.createUser("ksks@sksk.com","","");

        //when
        Long savedId = userService.join(user);

        //then
        em.flush();
        assertEquals(user, userRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원() throws Exception {
        //given
        User user1 = new User();
        user1.createUser("ksks@sksk.com","","");

        User user2 = new User();
        user2.createUser("ksks@sksk.com","","");

        //when
        userService.join(user1);
        userService.join(user2);

        //then
        fail("예외 발생 x");
    }

}