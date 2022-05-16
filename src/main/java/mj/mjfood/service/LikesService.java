package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.repository.LikesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;

    @Transactional
    public Long createLikes(Long userId, Long StoreId) {
        return 1L;
    }
}
