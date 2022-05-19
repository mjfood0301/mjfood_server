package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.dto.CreateReviewReq;
import mj.mjfood.entity.Review;
import mj.mjfood.entity.Store;
import mj.mjfood.entity.User;
import mj.mjfood.repository.ReviewRepository;
import mj.mjfood.repository.StoreRepository;
import mj.mjfood.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Long createReview(CreateReviewReq createReviewReq) {
        User user = userRepository.findOne(createReviewReq.getUserId());
        Store store = storeRepository.findOne(createReviewReq.getStoreId());

        Review review = Review.create(user, store, createReviewReq.getRate(), createReviewReq.getContent());

        reviewRepository.save(review);

        return review.getId();
    }
}
