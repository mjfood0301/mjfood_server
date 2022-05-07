package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(length = 20)
    private String name;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;


    public void createUser(String email, String name, String image) {
        this.email = email;
        this.name = name;
        this.image = image;
    }
}
