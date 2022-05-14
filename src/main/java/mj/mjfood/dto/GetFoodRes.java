package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Menu;
import java.util.List;


@Data
public class GetFoodRes {
    private Long id;
    private String name;
    private String image;
    private String info;
    private List<Menu> menus;
}
