package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Food {

    @Id @GeneratedValue
    private Long foodId;

    private String name;

    private String image;

    private String info;

    @OneToMany(mappedBy = "food")
    private List<FoodDislike> foodDislikes = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<FoodTag> foodTags = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<Menu> menus = new ArrayList<>();
}
