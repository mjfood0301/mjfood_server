package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Menu extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @Column(length = 50)
    private String name;

    //==연관관계 메서드==//
    public void addFood(Food food) {
        this.food = food;
    }

    public void addStore(Store store) {
        this.store = store;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public static Menu createMenu(Food food, String name) {
        Menu menu = new Menu();
        menu.addFood(food);
        menu.changeName(name);
        return menu;
    }
}
