package com.hainguyen.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(targetEntity = BlogPersonal.class)
    private List<BlogPersonal> blogPersonals;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogPersonal> getBlogPersonals() {
        return blogPersonals;
    }

    public void setBlogPersonals(List<BlogPersonal> blogPersonals) {
        this.blogPersonals = blogPersonals;
    }
}
