package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Food {

    @Id @GeneratedValue
    private Long foodId;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String info;

    @OneToMany(mappedBy = "food")
    private List<FoodDislike> foodDislikes = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<FoodTag> foodTags = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<Menu> menus = new ArrayList<>();
}
