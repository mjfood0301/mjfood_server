package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
public class User {

    @Id @GeneratedValue
    private Long userId;

    private String image;

    @Column(length = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;


}
