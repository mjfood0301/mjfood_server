package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Dislike {

    @Id @GeneratedValue
    private long dislikeId;

    @Column(length = 30)
    private String name;

}
