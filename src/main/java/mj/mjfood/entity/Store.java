package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Store extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(precision = 20)
    private BigDecimal locationX;

    @Column(precision = 20)
    private BigDecimal locationY;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();
}
