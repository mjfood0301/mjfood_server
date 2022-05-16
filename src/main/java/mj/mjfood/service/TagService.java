package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Tag;
import mj.mjfood.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TagService {

    private final TagRepository tagRepository;

    @Transactional
    public Long createTag(String name) {
        Tag tag = new Tag();
        tag.changeName(name);

        tagRepository.save(tag);
        return tag.getId();
    }
}
