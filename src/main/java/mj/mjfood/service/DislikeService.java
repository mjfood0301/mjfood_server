package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Dislike;
import mj.mjfood.repository.DislikeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DislikeService {

    private final DislikeRepository dislikeRepository;

    public Long save(Dislike dislike) {
        dislikeRepository.save(dislike);
        return dislike.getId();
    }
}
