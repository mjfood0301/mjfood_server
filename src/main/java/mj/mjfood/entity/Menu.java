package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Menu {

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

    @Column(columnDefinition = "TEXT")
    private String image;

}
