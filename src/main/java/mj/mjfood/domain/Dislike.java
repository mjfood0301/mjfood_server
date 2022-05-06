package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Dislike {

    @Id @GeneratedValue
    private long dislikeId;

    private String name;

}
