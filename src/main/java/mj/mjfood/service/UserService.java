package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.User;
import mj.mjfood.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {

        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByEmail(user.getEmail());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void update(Long id, String email, String name, String picture) {
        User user = userRepository.findOne(id);
        user.createUser(email,name,picture);
    }
}
