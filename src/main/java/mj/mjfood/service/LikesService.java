package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.entity.Likes;
import mj.mjfood.entity.Store;
import mj.mjfood.entity.User;
import mj.mjfood.repository.LikesRepository;
import mj.mjfood.repository.StoreRepository;
import mj.mjfood.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Long createLikes(Long userId, Long storeId) {
        //엔티티 조회
        User user = userRepository.findOne(userId);
        Store store = storeRepository.findOne(storeId);

        //like 생성
        Likes likes = Likes.createLikes(user, store);

        likesRepository.save(likes);

        return likes.getId();
    }

    public List<Likes> findByUser(Long userId) {
        //엔티티 조회
        User user = userRepository.findOne(userId);
        //
        return likesRepository.findByUser(user);
    }

    @Transactional
    public void deleteLikes(Long userId, Long storeId) throws BaseException {
        //엔티티 조회
        User user = userRepository.findOne(userId);
        Store store = storeRepository.findOne(storeId);

        List<Likes> likes = likesRepository.findByUserAndStore(user, store);
        for (Likes like : likes) {
            like.delete();
        }
    }
}
