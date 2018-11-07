package com.hainguyen.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogPersonal")
public class BlogPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String author;
    private String image;

    public BlogPersonal() {
    }

    public BlogPersonal(String title, String description, String author, String image) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}