package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Tag {

    @Id @GeneratedValue
    private Long tagId;

    @Column(length = 50)
    private String name;

}
