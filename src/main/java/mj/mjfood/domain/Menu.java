package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Menu {

    @Id @GeneratedValue
    private Long menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    private String name;

    private String profileImage;

}
