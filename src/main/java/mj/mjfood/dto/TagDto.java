package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Tag;

@Data
public class TagDto {
    private Long tagId;
    private String name;

    public TagDto(Tag tag) {
        this.tagId = tag.getId();
        this.name = tag.getName();
    }
}
