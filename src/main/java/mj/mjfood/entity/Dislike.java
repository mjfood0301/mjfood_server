package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Dislike extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "dislike_id")
    private Long id;

    @Column(length = 30)
    private String name;

    public void changeName(String name) {
        this.name = name;
    }

}
