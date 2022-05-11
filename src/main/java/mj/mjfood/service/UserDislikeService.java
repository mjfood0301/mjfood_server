package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Dislike;
import mj.mjfood.entity.User;
import mj.mjfood.entity.UserDislike;
import mj.mjfood.repository.DislikeRepository;
import mj.mjfood.repository.UserDislikeRepository;
import mj.mjfood.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserDislikeService {
    
    private final UserDislikeRepository userDislikeRepository;
    private final UserRepository userRepository;
    private final DislikeRepository dislikeRepository;


}
