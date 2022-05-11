package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.entity.Dislike;
import mj.mjfood.entity.User;
import mj.mjfood.entity.UserDislike;
import mj.mjfood.repository.DislikeRepository;
import mj.mjfood.repository.UserDislikeRepository;
import mj.mjfood.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final DislikeRepository dislikeRepository;
    private final UserDislikeRepository userDislikeRepository;

    @Transactional
    public Long join(User user) {

        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Long dislike(Long userId, Long dislikeId) {
        User user = userRepository.findOne(userId);
        //엔티티 조회
        Dislike dislike = dislikeRepository.findOne(dislikeId);

        // UserDislike 생성
        UserDislike userDislike = UserDislike.createUserDislike(dislike);

        user.addUserDislike(userDislike);

        return userDislike.getId();
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

    @Transactional
    public void quit(Long userId) throws BaseException {
        User user = userRepository.findOne(userId);

        user.quit();
    }

    @Transactional
    public void updateDislikes(Long userId, List<Long> dislikes) {
        //엔티티 조회
        User user = userRepository.findOne(userId);
        List<Dislike> dislikeList = dislikes.stream()
                .map(dislikeRepository::findOne)
                .collect(toList());

        for (Dislike dislike : dislikeList) {
            List<UserDislike> findByUserDislike = userDislikeRepository.findByUserDislike(user, dislike);
            if(!findByUserDislike.isEmpty()){
                user.deleteDislikes(dislike);
            }else {
                UserDislike userDislike = UserDislike.createUserDislike(dislike);
                user.addUserDislike(userDislike);
            }
        }

    }
}
