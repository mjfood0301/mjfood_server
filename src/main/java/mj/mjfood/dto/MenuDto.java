package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Menu;

import java.math.BigDecimal;

@Data
public class MenuDto {

    private String menuName;
    private BigDecimal locationX;
    private BigDecimal locationY;

    public MenuDto(Menu menu) {
        this.menuName = menu.getName();
        this.locationX = menu.getStore().getLocationX();
        this.locationY = menu.getStore().getLocationY();
    }
}
