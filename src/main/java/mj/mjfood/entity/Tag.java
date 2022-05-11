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
public class Tag extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    @Column(length = 50)
    private String name;

}
