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

    @OneToMany(mappedBy = "food")
    private List<FoodDislike> foodDislikes = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<FoodTag> foodTags = new ArrayList<>();

    @OneToMany(mappedBy = "food")
    private List<Menu> menus = new ArrayList<>();
}
