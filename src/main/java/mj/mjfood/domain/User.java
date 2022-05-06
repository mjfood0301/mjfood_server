package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User {

    @Id @GeneratedValue
    private Long userId;

    private String image;

    private String name;

    private String email;

    private LocalDate birthDate;


}
