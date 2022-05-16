package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Food extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "food_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String info;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodDislike> foodDislikes = new ArrayList<>();

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodTag> foodTags = new ArrayList<>();

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    public void createFood(String name, String image, String info) {
        this.name = name;
        this.image = image;
        this.info = info;
    }

    //==연관관계 메서드==//
    private void addFoodDislike(FoodDislike foodDislike) {
        foodDislikes.add(foodDislike);
        foodDislike.addFood(this);
    }

    private void addFoodTag(FoodTag foodTag) {
        foodTags.add(foodTag);
        foodTag.addFood(this);
    }

    private void addMenu(Menu menu) {
        menus.add(menu);
        menu.addFood(this);
    }

    //==생성 메서드==//
    public static Food createFood(String name, String image, String info, List<FoodDislike> foodDislikes, List<FoodTag> foodTags) {
        Food food = new Food();
        food.createFood(name,image,info);
        for (FoodDislike foodDislike : foodDislikes) {
            food.addFoodDislike(foodDislike);
        }
        for (FoodTag foodTag : foodTags) {
            food.addFoodTag(foodTag);
        }

        return food;
    }


}
