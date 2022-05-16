package mj.mjfood.dto;

import lombok.Data;

@Data
public class CreateMenuDto {

    private final Long foodId;
    private final String name;

    public CreateMenuDto(Long foodId, String name) {
        this.foodId = foodId;
        this.name = name;
    }
}
