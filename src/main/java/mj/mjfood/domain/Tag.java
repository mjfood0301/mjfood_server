package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Tag {

    @Id @GeneratedValue
    private Long tagId;

    private String name;

}
