package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Dislike {

    @Id @GeneratedValue
    @Column(name = "dislike_id")
    private Long id;

    @Column(length = 30)
    private String name;

}
