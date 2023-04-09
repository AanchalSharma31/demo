package com.example.demo.modal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;

    private String title;

    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Comment> comments;

}
