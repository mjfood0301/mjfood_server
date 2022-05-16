package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.Menu;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Data
public class GetFoodRes {
    private Long id;
    private String name;
    private String image;
    private String info;
    private List<MenuDto> menus;

    public GetFoodRes(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.image = food.getImage();
        this.info = food.getInfo();
        this.menus = food.getMenus().stream()
                .map(MenuDto::new)
                .collect(toList());
    }
}
